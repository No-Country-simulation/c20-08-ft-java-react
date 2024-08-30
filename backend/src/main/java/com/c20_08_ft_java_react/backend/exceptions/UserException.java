package com.c20_08_ft_java_react.backend.exceptions;

import lombok.Getter;

@Getter
public class UserException extends Exception{

    private final int code;

    public UserException(String msg, int code){
        super(msg);
        this.code = code;
    }

}
