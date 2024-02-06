package com.cjpm.gestorcoches.exception;

import java.io.Serial;

public class CocheBadRequestException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public CocheBadRequestException(String msg) {
        super(msg);
    }
}

