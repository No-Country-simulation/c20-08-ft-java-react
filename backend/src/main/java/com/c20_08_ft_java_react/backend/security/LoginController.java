package com.c20_08_ft_java_react.backend.security;

import com.c20_08_ft_java_react.backend.exceptions.JwtException;
import com.c20_08_ft_java_react.backend.exceptions.UserException;
import com.c20_08_ft_java_react.backend.repositories.UserRepository;
import com.c20_08_ft_java_react.backend.security.jwt.JwtService;
import com.c20_08_ft_java_react.backend.security.request.UserRequestLogin;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid UserRequestLogin userReq) throws UserException, JwtException {
        if (!userRepository.existsByUsername(userReq.username())) throw new UserException("El usuario no se encuentra registrado en la base de datos",400);
        if(!Objects.requireNonNull(userRepository.findByUsername(userReq.username()).orElse(null)).isEnabled())  throw new UserException("La cuenta de usuario no se encuentra activada, revise su email para activar su cuenta",400);
        try{
            authenticationService.authenticate(userReq.username(),userReq.password());
        } catch (Exception e){
            throw new UserException("Contraseña incorrecta",403);
        }
        String token;
        try{
            token = jwtService.generateToken(userReq.username());
        } catch (Exception ex){
            throw new JwtException("Ocurrio un error al generar el token",500);
        }
        return ResponseEntity.ok(
                Map.of(
                        "user", userReq.username(),
                        "token",token,
                        "role","role"
                )
        );
    }

}
