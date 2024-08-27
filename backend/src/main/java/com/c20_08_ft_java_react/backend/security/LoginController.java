package com.c20_08_ft_java_react.backend.security;

import com.c20_08_ft_java_react.backend.security.request.UserRequestLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<?> login(UserRequestLogin userReq){
        authenticationService.authenticate(userReq.username(),userReq.password());
        return ResponseEntity.ok("success");
    }

}
