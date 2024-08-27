package com.c20_08_ft_java_react.backend.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class JwtService {

    @Autowired
    private Environment environment;

    public String generateToken(String username){
        Algorithm algorithm = Algorithm.HMAC256(Objects.requireNonNull(environment.getProperty("SECRET_KEY_TOKEN_LOGIN")));
        return JWT.create()
                .withIssuer("andrea-namaste")
                .withSubject(username)
                .sign(algorithm);
    }

    public String validateAndGetSubject(String token) {
        Algorithm algorithm = Algorithm.HMAC256(Objects.requireNonNull(environment.getProperty("SECRET_KEY_TOKEN_LOGIN")));
        return JWT.require(algorithm)
                .withIssuer("andrea-namaste")
                .build()
                .verify(token)
                .getSubject();
    }

}
