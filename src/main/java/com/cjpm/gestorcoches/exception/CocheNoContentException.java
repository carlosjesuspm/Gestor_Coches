package com.cjpm.gestorcoches.exception;

import java.io.Serial;

public class CocheNoContentException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public CocheNoContentException(String msg){
        super(msg);
    }
}

