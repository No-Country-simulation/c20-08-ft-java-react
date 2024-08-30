package com.c20_08_ft_java_react.backend.services;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.c20_08_ft_java_react.backend.enums.Role;
import com.c20_08_ft_java_react.backend.exceptions.JwtException;
import com.c20_08_ft_java_react.backend.exceptions.UserException;
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

    public String registerUser(UserRegisterRequest userRequest) throws UserException {
        if (userRepository.existsByUsername(userRequest.username()))
            throw new UserException("Ya se encuentra registrado un usuario con ese nombre",400);
        if (userRepository.existsByEmail(userRequest.email()))
            throw new UserException("Ya se encuentra registrado un usuario con ese email",400);
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
    public void activateUser(String token, String username) throws UserException, JwtException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserException("El usuario no se encuentra registrado",400)
        );
        if(user.isEnabled()) throw new UserException("La cuenta ya se encuentra activada",200);
        String subject;
        try{
            subject = jwtService.validateAndGetSubjectActivateAccount(token);
        } catch (JWTDecodeException exception){
            throw new JwtException(exception.getMessage(),400);
        } catch (SignatureVerificationException exception){
            throw new JwtException(exception.getMessage(),403);
        }
        if (!subject.equals(username))
            throw new UserException("El token no corresponde al usuario",400);
        user.setEnabled(true);
    }

}

