package com.cjpm.gestorcoches.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {
    /**
     * Método encargado de capturar error NotFound
     * @param ex -
     * @param request -
     * @return ResponseEntity<MensajeErrorCoche>
     */
    @ExceptionHandler(CocheNotFoundException.class)
    public ResponseEntity<MensajeErrorCoche> cocheNotFoundException(CocheNotFoundException ex, WebRequest request){
        MensajeErrorCoche mensajeErrorPersonalizado = new MensajeErrorCoche(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<MensajeErrorCoche>(mensajeErrorPersonalizado, HttpStatus.NOT_FOUND);
    }

    /**
     * Método encargado de capturar error BadRequest
     * @param ex -
     * @param request -
     * @return ResponseEntity<MensajeErrorCoche>
     */
    @ExceptionHandler(CocheBadRequestException.class)
    public ResponseEntity<MensajeErrorCoche> cocheBadRequestException(CocheBadRequestException ex, WebRequest request){
        MensajeErrorCoche mensajeErrorPersonalizado = new MensajeErrorCoche(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<MensajeErrorCoche>(mensajeErrorPersonalizado, HttpStatus.BAD_REQUEST);
    }

    /**
     * Método encargado de capturar error GlobalExceptionHandler
     * @param ex -
     * @param request -
     * @return ResponseEntity<MensajeErrorCoche>
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeErrorCoche> globalExceptionHandler(Exception ex, WebRequest request){
        MensajeErrorCoche mensajeErrorPersonalizado = new MensajeErrorCoche(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<MensajeErrorCoche>(mensajeErrorPersonalizado, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Método encargado de capturar error NoContent
     * @param ex -
     * @param request -
     * @return ResponseEntity<MensajeErrorCoche>
     */
    @ExceptionHandler(CocheNoContentException.class)
    public ResponseEntity<MensajeErrorCoche> cocheNoContentException(CocheNoContentException ex, WebRequest request){
        MensajeErrorCoche mensajeErrorPersonalizado = new MensajeErrorCoche(
                HttpStatus.NO_CONTENT.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<MensajeErrorCoche>(mensajeErrorPersonalizado, HttpStatus.NO_CONTENT);
    }
}
