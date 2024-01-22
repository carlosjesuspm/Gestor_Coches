package com.cjpm.gestorcoches.entities;

import jakarta.persistence.*;


/**
 * Tabla Coche Combustión
 */
@Entity
@Table(name="coches_combustion")
public class CocheCombustion extends Coche  {

    @Column(name = "motor_combustion")
    private boolean motorCombustion;

    public CocheCombustion() {
    }

    public CocheCombustion( boolean motorCombustion) {
        this.motorCombustion = motorCombustion;
    }

    public CocheCombustion(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria,boolean motorCombustion) {
        super(idCoche, marca, modelo, color, aireAcondicionado, motor, bateria);
        this.motorCombustion = motorCombustion;
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
                "motorCombustion=" + motorCombustion +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", aireAcondicionado=" + aireAcondicionado +
                ", motor=" + motor +
                ", bateria=" + bateria +
                '}';
    }
}
