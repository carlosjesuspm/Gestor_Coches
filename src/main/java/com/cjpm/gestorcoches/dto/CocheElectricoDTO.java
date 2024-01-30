package com.cjpm.gestorcoches.dto;

import com.cjpm.gestorcoches.entities.CocheElectrico;

import java.io.Serial;
import java.io.Serializable;

public class CocheElectricoDTO extends CocheDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private boolean bateriaElectrica;

    public CocheElectricoDTO() {

    }

    public CocheElectricoDTO(CocheElectrico cocheElectrico) {

    }

    public CocheElectricoDTO(boolean bateriaElectrica) {
        this.bateriaElectrica = bateriaElectrica;
    }

    public CocheElectricoDTO(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, boolean bateriaElectrica) {
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
