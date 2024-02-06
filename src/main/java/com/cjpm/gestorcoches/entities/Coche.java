package com.cjpm.gestorcoches.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Tabla Coche
 */

@MappedSuperclass
public abstract class Coche{


    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull
    protected long idCoche;
    @Column(name = "marca")
    @NotNull
    @NotEmpty
    protected String marca;
    @Column(name = "modelo")
    @NotNull
    @NotEmpty
    protected String modelo;
    @Column(name = "color")
    @NotNull
    @NotEmpty
    protected String color;
    @Column(name = "aire_acondicionado_encendido")
    @NotNull
    protected boolean aireAcondicionadoEncendido;
    @Column(name = "motor_encendido")
    @NotNull
    protected boolean motorEncendido;
    @Column(name = "bateria_encendida")
    @NotNull
    protected boolean bateriaEncendida;

    //Constructores
    public Coche() {
    }

    public Coche(long idCoche, String marca, String modelo, String color, boolean aireAcondicionadoEncendido, boolean motorEncendido, boolean bateriaEncendida) {
        this.idCoche = idCoche;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.aireAcondicionadoEncendido = aireAcondicionadoEncendido;
        this.motorEncendido = motorEncendido;
        this.bateriaEncendida = bateriaEncendida;
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

    public boolean getAireAcondicionadoEncendido() {
        return aireAcondicionadoEncendido;
    }

    public void setAireAcondicionadoEncendido(Boolean aireAcondicionadoEncendido) {
        this.aireAcondicionadoEncendido = aireAcondicionadoEncendido;
    }

    public boolean getMotorEncendido() {
        return motorEncendido;
    }

    public void setMotorEncendido(Boolean motorEncendido) {
        this.motorEncendido = motorEncendido;
    }

    public boolean getBateriaEncendida() {
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

