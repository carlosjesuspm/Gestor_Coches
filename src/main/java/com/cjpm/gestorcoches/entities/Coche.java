package com.cjpm.gestorcoches.entities;
import jakarta.persistence.*;

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
    protected boolean aireAcondicionadoEncendido;
    @Column(name = "motor")
    protected boolean motorEncendido;
    @Column(name = "bateria")
    protected boolean bateriaEncendida;

    //Constructores
    public Coche() {
    }

    public Coche(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria) {
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

    //Funciones Coche
    public boolean encenderAireAcondicionado(){
        return aireAcondicionadoEncendido =true;
    };
    public boolean encederBateria(){
        return bateriaEncendida =true;
    };
    public boolean encenderMotor(){
        return motorEncendido =true;
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

