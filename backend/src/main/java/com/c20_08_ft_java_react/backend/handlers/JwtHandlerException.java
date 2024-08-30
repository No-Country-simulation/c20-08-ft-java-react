package com.c20_08_ft_java_react.backend.handlers;

import com.c20_08_ft_java_react.backend.exceptions.JwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class JwtHandlerException {

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<?> jwtException(JwtException exception){
        return ResponseEntity.status(exception.getCode()).body(
                Map.of("message",exception.getMessage())
        );
    }

}
