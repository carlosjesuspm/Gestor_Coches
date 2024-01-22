package com.cjpm.gestorcoches.entities;
import jakarta.persistence.*;

import java.io.Serializable;

/**
 * Tabla Coche
 */

@MappedSuperclass
public abstract class Coche implements IFuncionesCoche{


    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCoche;
    @Column(name = "marca")
    protected String marca;
    @Column(name = "modelo")
    protected String modelo;
    @Column(name = "color")
    protected String color;
    @Column(name = "aire_acondicionado")
    protected boolean aireAcondicionado;
    @Column(name = "motor")
    protected boolean motor;
    @Column(name = "bateria")
    protected boolean bateria;

    //Constructores
    public Coche() {
    }

    public Coche(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria) {
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

    public boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean getMotor() {
        return motor;
    }

    public void setMotor(Boolean motor) {
        this.motor = motor;
    }

    public boolean getBateria() {
        return bateria;
    }

    public void setBateria(Boolean bateria) {
        this.bateria = bateria;
    }

    //Funciones Coche
    public boolean encenderAireAcondicionado(){
        return aireAcondicionado=true;
    };
    public boolean encederBateria(){
        return bateria=true;
    };
    public boolean encenderMotor(){
        return motor=true;
    };

}

