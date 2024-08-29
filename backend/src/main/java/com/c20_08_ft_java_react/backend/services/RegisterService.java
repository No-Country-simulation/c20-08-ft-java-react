package com.c20_08_ft_java_react.backend.services;

import com.c20_08_ft_java_react.backend.enums.Role;
import com.c20_08_ft_java_react.backend.models.UserEntity;
import com.c20_08_ft_java_react.backend.repositories.UserRepository;
import com.c20_08_ft_java_react.backend.request.UserRegisterRequest;
import com.c20_08_ft_java_react.backend.security.jwt.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String registerUser(UserRegisterRequest userRequest){
        if (userRepository.existsByUsername(userRequest.username()))
            throw new RuntimeException("Ya se encuentra registrado un usuario con ese nombre");
        if (userRepository.existsByEmail(userRequest.email()))
            throw new RuntimeException("Ya se encuentra registrado un usuario con ese email");
        System.out.println(userRequest);
        userRepository.save(UserEntity.builder()
                        .username(userRequest.username())
                        .password(passwordEncoder.encode(userRequest.password()))
                        .email(userRequest.email())
                        .role(Role.USER)
                .build());
        return jwtService.generateTokenToActivateAccount(userRequest.username());
    }

    @Transactional
    public void activateUser(String token, String username){
        String subject = jwtService.validateAndGetSubjectActivateAccount(token);
        if (!subject.equals(username))
            throw new RuntimeException("El token no corresponde al usuario");
        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("El usuario no se encuentra registrado")
        );
        user.setEnabled(true);
    }

}

