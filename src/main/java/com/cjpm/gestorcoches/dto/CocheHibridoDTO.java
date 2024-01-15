package com.cjpm.gestorcoches.dto;

import java.io.Serializable;

public class CocheHibridoDTO extends CocheDTO implements Serializable {

    private long idCocheHibrido;
    private boolean tanqueHidrogeno;

    public CocheHibridoDTO() {

    }
    public CocheHibridoDTO(long idCocheHibrido, boolean tanqueHidrogeno) {
        this.idCocheHibrido = idCocheHibrido;
        this.tanqueHidrogeno = tanqueHidrogeno;
    }

    public CocheHibridoDTO(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, long idCocheHibrido, boolean tanqueHidrogeno) {
        super(idCoche, marca, modelo, color, aireAcondicionado, motor, bateria);
        this.idCocheHibrido = idCocheHibrido;
        this.tanqueHidrogeno = tanqueHidrogeno;
    }

    public long getIdCocheHibrido() {
        return idCocheHibrido;
    }

    public void setIdCocheHibrido(long idCocheHibrido) {
        this.idCocheHibrido = idCocheHibrido;
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
                "idCocheHibrido=" + idCocheHibrido +
                ", tanqueHidrogeno=" + tanqueHidrogeno +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", aireAcondicionado=" + aireAcondicionado +
                ", motor=" + motor +
                ", bateria=" + bateria +
                '}';
    }
}
