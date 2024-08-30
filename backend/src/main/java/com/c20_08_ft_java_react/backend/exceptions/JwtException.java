package com.c20_08_ft_java_react.backend.exceptions;

import lombok.Getter;

@Getter
public class JwtException extends Exception{

    private final int code;

    public JwtException(String msg, int code){
        super(msg);
        this.code=code;
    }

}
