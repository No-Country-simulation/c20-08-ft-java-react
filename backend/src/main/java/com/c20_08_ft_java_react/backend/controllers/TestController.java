package com.c20_08_ft_java_react.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/public")
    public ResponseEntity<?> publicEndPoint(){
        return ResponseEntity.ok("success public endpoint");
    }

    @GetMapping("/protected")
    public ResponseEntity<?> protectedEndPoint(){
        return ResponseEntity.ok("Success protected endpoint");
    }

}
