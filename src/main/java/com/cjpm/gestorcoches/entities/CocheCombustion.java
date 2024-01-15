package com.cjpm.gestorcoches.entities;

import jakarta.persistence.*;


/**
 * Tabla Coche Combustión
 */
@Entity
@Table(name="coches_combustion")
public class CocheCombustion extends Coche  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCocheCombustion;
    @Column(name = "motor_combustion")
    private boolean motorCombustion;

    public CocheCombustion() {
    }

    public CocheCombustion(long idCocheCombustion, boolean motorCombustion) {
        this.idCocheCombustion = idCocheCombustion;
        this.motorCombustion = motorCombustion;
    }

    public CocheCombustion(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, long idCocheCombustion, boolean motorCombustion) {
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
}
