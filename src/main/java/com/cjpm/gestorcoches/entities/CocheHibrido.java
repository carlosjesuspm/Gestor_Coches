package com.cjpm.gestorcoches.entities;

import jakarta.persistence.*;

/**
 * Tabla Coche Híbrido
 */
@Entity
@Table(name="coches_hibrido")
public class CocheHibrido extends Coche {


    @Column(name = "tanque_hidrogeno")
    private boolean tanqueHidrogeno=true;

    public CocheHibrido() {
    }

    public CocheHibrido(boolean tanqueHidrogeno) {
        this.tanqueHidrogeno = tanqueHidrogeno;
    }

    public CocheHibrido(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, boolean tanqueHidrogeno) {
        super(idCoche, marca, modelo, color, aireAcondicionado, motor, bateria);
        this.tanqueHidrogeno = tanqueHidrogeno;
    }


    public boolean isTanqueHidrogeno() {
        return tanqueHidrogeno;
    }

    public void setTanqueHidrogeno(boolean tanqueHidrogeno) {
        this.tanqueHidrogeno = tanqueHidrogeno;
    }

    @Override
    public String toString() {
        return "CocheHibrido{" +
                ", Tanque Hidrogeno=" + tanqueHidrogeno +
                ", Marca='" + marca + '\'' +
                ", Modelo='" + modelo + '\'' +
                ", Color='" + color + '\'' +
                ", Aire Acondicionado Encendido=" + aireAcondicionadoEncendido +
                ", Motor Encendido=" + motorEncendido +
                ", Batería Encendida=" + bateriaEncendida +
                '}';
    }
}
