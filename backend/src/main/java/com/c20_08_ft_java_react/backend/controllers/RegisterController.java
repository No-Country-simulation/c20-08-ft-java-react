package com.c20_08_ft_java_react.backend.controllers;

import com.c20_08_ft_java_react.backend.exceptions.JwtException;
import com.c20_08_ft_java_react.backend.exceptions.UserException;
import com.c20_08_ft_java_react.backend.request.UserRegisterRequest;
import com.c20_08_ft_java_react.backend.services.RegisterService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/account")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRegisterRequest user) throws UserException {
        String token_activation = registerService.registerUser(user);
        return ResponseEntity.ok(
                Map.of(
                        "message","Usuario registrado con exito",
                        "activation_token",token_activation
                )
        );
    }

    @GetMapping("/activate")
    public ResponseEntity<?> activateUser(@RequestParam @NotBlank String token, @RequestParam @NotBlank String username) throws UserException, JwtException {
        registerService.activateUser(token,username);
        return ResponseEntity.ok("Cuenta activada existosamente");
    }

}