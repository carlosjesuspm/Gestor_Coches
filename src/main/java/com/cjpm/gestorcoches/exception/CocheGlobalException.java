package com.cjpm.gestorcoches.exception;

import java.io.Serial;

public class CocheGlobalException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public CocheGlobalException(String msg){
        super(msg);
    }
}
