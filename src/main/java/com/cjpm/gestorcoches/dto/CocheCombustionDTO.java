package com.cjpm.gestorcoches.dto;

import com.cjpm.gestorcoches.entities.Coche;
import com.cjpm.gestorcoches.entities.CocheCombustion;

import java.io.Serial;
import java.io.Serializable;

public class CocheCombustionDTO extends CocheDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private boolean motorCombustion=true;

    public CocheCombustionDTO() {

    }

    public CocheCombustionDTO(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, boolean motorCombustion) {
        super(idCoche, marca, modelo, color, aireAcondicionado, motor, bateria);
        this.motorCombustion = motorCombustion;
    }

    public CocheCombustionDTO(Coche coche, boolean motorCombustion) {
        super(coche);
        this.motorCombustion=motorCombustion;
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
                "Motor Combustion=" + motorCombustion +
                ", Marca='" + marca + '\'' +
                ", Modelo='" + modelo + '\'' +
                ", Color='" + color + '\'' +
                ", Aire Acondicionado Encendido=" + aireAcondicionadoEncendido +
                ", Motor Encendido=" + motorEncendido +
                ", Batería Encendida=" + bateriaEncendida +
                '}';
    }
}
