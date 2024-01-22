package com.cjpm.gestorcoches.dto;

import com.cjpm.gestorcoches.entities.CocheElectrico;

import java.io.Serializable;

public class CocheElectricoDTO extends CocheDTO implements Serializable {


    private long idCocheElectrico;
    private boolean bateriaElectrica;

    public CocheElectricoDTO() {

    }

    public CocheElectricoDTO(CocheElectrico cocheElectrico) {

    }

    public CocheElectricoDTO(long idCocheElectrico, boolean bateriaElectrica) {
        this.idCocheElectrico = idCocheElectrico;
        this.bateriaElectrica = bateriaElectrica;
    }

    public CocheElectricoDTO(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, long idCocheElectrico, boolean bateriaElectrica) {
        super(idCoche, marca, modelo, color, aireAcondicionado, motor, bateria);
        this.idCocheElectrico = idCocheElectrico;
        this.bateriaElectrica = bateriaElectrica;
    }



    public long getIdCocheElectrico() {
        return idCocheElectrico;
    }

    public void setIdCocheElectrico(long idCocheElectrico) {
        this.idCocheElectrico = idCocheElectrico;
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
                "idCocheElectrico=" + idCocheElectrico +
                ", bateriaElectrica=" + bateriaElectrica +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", aireAcondicionado=" + aireAcondicionado +
                ", motor=" + motor +
                ", bateria=" + bateria +
                '}';
    }
}
