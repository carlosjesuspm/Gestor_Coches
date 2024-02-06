package com.cjpm.gestorcoches.dto;

import com.cjpm.gestorcoches.entities.Coche;

import java.io.Serial;
import java.io.Serializable;

public abstract class CocheDTO implements Serializable, IFuncionesCoche {

    @Serial
    private static final long serialVersionUID = 1L;

    //Atributos
    protected long idCoche;
    protected String marca;
    protected String modelo;

    protected String color;

    protected Boolean aireAcondicionadoEncendido;

    protected Boolean motorEncendido;

    protected Boolean bateriaEncendida;

    //Constructores
    public CocheDTO() {
    }

    public CocheDTO(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionadoEncendido, Boolean motorEncendido, Boolean bateriaEncendida) {
        this.idCoche = idCoche;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.aireAcondicionadoEncendido = aireAcondicionadoEncendido;
        this.motorEncendido = motorEncendido;
        this.bateriaEncendida = bateriaEncendida;
    }

    public CocheDTO(Coche coche) {
        this.idCoche = coche.getIdCoche();
        this.marca = coche.getMarca();
        this.modelo = coche.getModelo();
        this.color = coche.getColor();
        this.aireAcondicionadoEncendido = coche.getAireAcondicionadoEncendido();
        this.motorEncendido = coche.getMotorEncendido();
        this.bateriaEncendida = coche.getBateriaEncendida();
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

    //Funciones Coche
    public void encenderAireAcondicionado(){
        aireAcondicionadoEncendido = true;
    };
    public void encederBateria(){
        bateriaEncendida = true;
    };
    public void encenderMotor(){
        motorEncendido = true;
    };

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
