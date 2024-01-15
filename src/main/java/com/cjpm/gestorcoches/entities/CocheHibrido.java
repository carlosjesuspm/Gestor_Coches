package com.cjpm.gestorcoches.entities;

import jakarta.persistence.*;

/**
 * Tabla Coche Híbrido
 */
@Entity
@Table(name="coches_hibrido")
public class CocheHibrido extends Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCocheHibrido;

    @Column(name = "tanque_hidrogeno")
    private boolean tanqueHidrogeno;

    public CocheHibrido(long idCocheHibrido, boolean tanqueHidrogeno) {
        this.idCocheHibrido = idCocheHibrido;
        this.tanqueHidrogeno = tanqueHidrogeno;
    }

    public CocheHibrido(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, long idCocheHibrido, boolean tanqueHidrogeno) {
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
