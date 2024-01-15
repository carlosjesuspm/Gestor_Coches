package com.cjpm.gestorcoches.entities;

import jakarta.persistence.*;

/**
 * Tabla Coche Eléctrico
 */
@Entity
@Table(name="coches_electrico")
public class CocheElectrico extends Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCocheElectrico;
    @Column(name = "bateria_electrica")
    private boolean bateriaElectrica;

    public CocheElectrico() {
    }

    public CocheElectrico(long idCocheElectrico, boolean bateriaElectrica) {
        this.idCocheElectrico = idCocheElectrico;
        this.bateriaElectrica = bateriaElectrica;
    }

    public CocheElectrico(long idCoche, String marca, String modelo, String color, Boolean aireAcondicionado, Boolean motor, Boolean bateria, long idCocheElectrico, boolean bateriaElectrica) {
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


}
