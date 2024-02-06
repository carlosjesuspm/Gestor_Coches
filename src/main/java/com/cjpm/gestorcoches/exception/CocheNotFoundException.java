package com.cjpm.gestorcoches.exception;

import java.io.Serial;

public class CocheNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public CocheNotFoundException(String msg){
        super(msg);
    }
}
