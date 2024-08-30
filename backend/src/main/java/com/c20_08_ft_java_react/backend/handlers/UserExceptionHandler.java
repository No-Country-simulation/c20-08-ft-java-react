package com.c20_08_ft_java_react.backend.handlers;

import com.c20_08_ft_java_react.backend.exceptions.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> userException(UserException exception){
        return ResponseEntity.status(exception.getCode()).body(
                Map.of(
                        "message", exception.getMessage()
                )
        );
    }

}
