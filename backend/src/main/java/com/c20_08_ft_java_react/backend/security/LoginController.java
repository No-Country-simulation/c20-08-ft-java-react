package com.c20_08_ft_java_react.backend.security;

import com.c20_08_ft_java_react.backend.security.jwt.JwtService;
import com.c20_08_ft_java_react.backend.security.request.UserRequestLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserRequestLogin userReq){
        authenticationService.authenticate(userReq.username(),userReq.password());
        String token = jwtService.generateToken(userReq.username());
        return ResponseEntity.ok(
                Map.of(
                        "user", userReq.username(),
                        "token",token,
                        "role","role"
                )
        );
    }

}
