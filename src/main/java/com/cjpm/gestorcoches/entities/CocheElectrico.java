package com.cjpm.gestorcoches.entities;

import jakarta.persistence.*;

/**
 * Tabla Coche Eléctrico
 */
@Entity
@Table(name="coches_electrico")
public class CocheElectrico extends Coche {

    @Column(name = "bateria_electrica")
    private boolean bateriaElectrica;

    public CocheElectrico() {
    }

    public CocheElectrico(boolean bateriaElectrica) {
        this.bateriaElectrica = bateriaElectrica;
    }

    public CocheElectrico(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, boolean bateriaElectrica) {
        super(idCoche, marca, modelo, color, aireAcondicionado, motor, bateria);
        this.bateriaElectrica = bateriaElectrica;
    }

    public boolean isBateriaElectrica() {
        return bateriaElectrica;
    }

    public void setBateriaElectrica(boolean bateriaElectrica) {
        this.bateriaElectrica = bateriaElectrica;
    }

    @Override
    public String toString() {
        return "CocheElectrico{" +
                "Bateria Eléctrica=" + bateriaElectrica +
                ", Marca='" + marca + '\'' +
                ", Modelo='" + modelo + '\'' +
                ", Color='" + color + '\'' +
                ", Aire Acondicionado Encendido=" + aireAcondicionadoEncendido +
                ", Motor Encendido=" + motorEncendido +
                ", Batería Encendida=" + bateriaEncendida +
                '}';
    }
}
