package com.cjpm.gestorcoches.dto;

import com.cjpm.gestorcoches.entities.CocheHibrido;

import java.io.Serial;
import java.io.Serializable;

public class CocheHibridoDTO extends CocheDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private boolean tanqueHidrogeno;

    public CocheHibridoDTO() {

    }

    public CocheHibridoDTO(CocheHibrido cocheHibrido) {

    }

    public CocheHibridoDTO(boolean tanqueHidrogeno) {
        this.tanqueHidrogeno = tanqueHidrogeno;
    }

    public CocheHibridoDTO(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, boolean tanqueHidrogeno) {
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
