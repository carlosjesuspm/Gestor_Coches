package com.cjpm.gestorcoches.dto;

import com.cjpm.gestorcoches.entities.CocheCombustion;

import java.io.Serializable;

public class CocheCombustionDTO extends CocheDTO implements Serializable {


    private long idCocheCombustion;
    private boolean motorCombustion;

    public CocheCombustionDTO() {

    }
    public CocheCombustionDTO(long idCocheCombustion, boolean motorCombustion) {
        this.idCocheCombustion = idCocheCombustion;
        this.motorCombustion = motorCombustion;
    }
    public CocheCombustionDTO(CocheCombustion cocheCombustion) {

    }

    public CocheCombustionDTO(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, long idCocheCombustion, boolean motorCombustion) {
        super(idCoche, marca, modelo, color, aireAcondicionado, motor, bateria);
        this.idCocheCombustion = idCocheCombustion;
        this.motorCombustion = motorCombustion;
    }

    public long getIdCocheCombustion() {
        return idCocheCombustion;
    }

    public void setIdCocheCombustion(long idCocheCombustion) {
        this.idCocheCombustion = idCocheCombustion;
    }

    public boolean isMotorCombustion() {
        return motorCombustion;
    }

    public void setMotorCombustion(boolean motorCombustion) {
        this.motorCombustion = motorCombustion;
    }

    @Override
    public String toString() {
        return "CocheCombustion{" +
                "idCocheCombustion=" + idCocheCombustion +
                ", motorCombustion=" + motorCombustion +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", aireAcondicionado=" + aireAcondicionado +
                ", motor=" + motor +
                ", bateria=" + bateria +
                '}';
    }
}
