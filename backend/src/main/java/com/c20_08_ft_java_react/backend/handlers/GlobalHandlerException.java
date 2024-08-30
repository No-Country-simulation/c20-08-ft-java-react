package com.c20_08_ft_java_react.backend.handlers;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.*;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<FieldError> errors = exception.getFieldErrors();
        List<Map<String,Object>> errorsResponse = new ArrayList<>();
        List<Map<String,String>> fieldsErrorResponse = new ArrayList<>();
        errorsResponse.add(Map.of("message","Todos los campos tienen que estar completos"));
        errors.forEach(error -> fieldsErrorResponse.add(
                Map.of(
                        error.getField(),
                        Objects.requireNonNull(error.getDefaultMessage())
                )
        ));
        errorsResponse.add(Map.of("fields",fieldsErrorResponse));
        return ResponseEntity.badRequest().body(errorsResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<?> handlerMethodValidationException(HandlerMethodValidationException exception){
        List<? extends MessageSourceResolvable> errors = exception.getAllErrors();
        List<Map<String,Object>> errorsResponse = new ArrayList<>();
        List<Map<String,String>> fieldsErrorResponse = new ArrayList<>();
        errorsResponse.add(Map.of("message","Todos los campos tienen que estar completos"));
        errors.forEach(error -> fieldsErrorResponse.add(
                Map.of(
                        Objects.requireNonNull(error.getArguments())[0].toString()
                                .split("]")[2]
                                .split("\\[")[1],
                        Objects.requireNonNull(error.getDefaultMessage())
                )
        ));
        errorsResponse.add(Map.of("fields",fieldsErrorResponse));
        return ResponseEntity.status(exception.getStatusCode()).body(errorsResponse);
    }

}
