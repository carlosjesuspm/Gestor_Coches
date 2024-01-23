package com.cjpm.gestorcoches.dto;



import java.io.Serializable;

public abstract class CocheDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    private long idCoche;
    protected String marca;
    protected String modelo;

    protected String color;

    protected Boolean aireAcondicionado;

    protected Boolean motor;

    protected Boolean bateria;

    //Constructores
    public CocheDTO() {
    }

    public CocheDTO(Boolean aireAcondicionado, Boolean motor, Boolean bateria) {
        this.aireAcondicionado = aireAcondicionado;
        this.motor = motor;
        this.bateria = bateria;
    }

    public CocheDTO(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria) {
        this.idCoche = idCoche;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.aireAcondicionado = aireAcondicionado;
        this.motor = motor;
        this.bateria = bateria;
    }

    //Getters y Setters
    public long getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(long idCoche) {
        this.idCoche = idCoche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getMotor() {
        return motor;
    }

    public void setMotor(Boolean motor) {
        this.motor = motor;
    }

    public Boolean getBateria() {
        return bateria;
    }

    public void setBateria(Boolean bateria) {
        this.bateria = bateria;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "idCoche=" + idCoche +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", aireAcondicionadoEncendido=" + aireAcondicionado +
                ", motorEncendido=" + motor +
                ", bateriaEncendida=" + bateria +
                '}';
    }


}
