package com.c20_08_ft_java_react.backend.services;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.c20_08_ft_java_react.backend.enums.Role;
import com.c20_08_ft_java_react.backend.exceptions.JwtException;
import com.c20_08_ft_java_react.backend.exceptions.UserException;
import com.c20_08_ft_java_react.backend.models.TareaEntify;
import com.c20_08_ft_java_react.backend.models.UserEntity;
import com.c20_08_ft_java_react.backend.repositories.TareaRepository;
import com.c20_08_ft_java_react.backend.repositories.UserRepository;
import com.c20_08_ft_java_react.backend.request.TareaRegisterRequest;
import com.c20_08_ft_java_react.backend.request.UserRegisterRequest;
import com.c20_08_ft_java_react.backend.security.jwt.JwtService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterTarea {

    @Autowired
    private TareaRepository tareaRepository;


    @Autowired
    private JwtService jwtService;

    public String registerTareas(TareaRegisterRequest tareaRequest) throws UserException {
/*
                @NotBlank String nombreTarea,
        @NotBlank String asunto,
        @NotBlank Date fechaexp;

  */
        tareaRepository.save(TareaEntify.builder()
                        .nombreTarea(tareaRequest.nombreTarea())
                        .asunto(tareaRequest.asunto())
                        .fechaexp(tareaRequest.fechaexp())
                .build());
        return jwtService.generateTokenToActivateAccount(tareaRequest.nombreTarea());
    }

    public void deleteTarea() {
        TareaEntify tar = tareaRepository.findByEtiquetaName(obtainUserName());
        TareaRepository.deleteByTarea(tar.etiquetaId());
        tareaRepository.delete(tar);

        logger.info("Tarea deleted");

    }





}

