package com.cjpm.gestorcoches.dto;



import java.io.Serializable;

public abstract class CocheDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    private long idCoche;
    protected String marca;
    protected String modelo;

    protected String color;

    protected Boolean aireAcondicionadoEncendido;

    protected Boolean motorEncendido;

    protected Boolean bateriaEncendida;

    //Constructores
    public CocheDTO() {
    }

    public CocheDTO(Boolean aireAcondicionado, Boolean motor, Boolean bateria) {
        this.aireAcondicionadoEncendido = aireAcondicionado;
        this.motorEncendido = motor;
        this.bateriaEncendida = bateria;
    }

    public CocheDTO(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria) {
        this.idCoche = idCoche;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.aireAcondicionadoEncendido = aireAcondicionado;
        this.motorEncendido = motor;
        this.bateriaEncendida = bateria;
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

    public Boolean getAireAcondicionadoEncendido() {
        return aireAcondicionadoEncendido;
    }

    public void setAireAcondicionadoEncendido(Boolean aireAcondicionadoEncendido) {
        this.aireAcondicionadoEncendido = aireAcondicionadoEncendido;
    }

    public Boolean getMotorEncendido() {
        return motorEncendido;
    }

    public void setMotorEncendido(Boolean motorEncendido) {
        this.motorEncendido = motorEncendido;
    }

    public Boolean getBateriaEncendida() {
        return bateriaEncendida;
    }

    public void setBateriaEncendida(Boolean bateriaEncendida) {
        this.bateriaEncendida = bateriaEncendida;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "Id Coche=" + idCoche +
                ", Marca='" + marca + '\'' +
                ", Modelo='" + modelo + '\'' +
                ", Color='" + color + '\'' +
                ", Aire Acondicionado Encendido=" + aireAcondicionadoEncendido +
                ", Motor Encendido=" + motorEncendido +
                ", Bateria Encendida=" + bateriaEncendida +
                '}';
    }


}
