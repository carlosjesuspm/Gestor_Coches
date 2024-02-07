package com.cjpm.gestorcoches.exception;

import java.util.Date;

public class MensajeErrorCoche {
    private int statusCode;
    private Date timeStamp;
    private String mensaje;
    private String descripcionError;



    public MensajeErrorCoche(int statusCode, Date timeStamp, String mensaje, String descripcionError) {
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
        this.mensaje = mensaje;
        this.descripcionError = descripcionError;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }
}
