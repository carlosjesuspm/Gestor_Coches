package com.cjpm.gestorcoches.facade;

import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import org.springframework.stereotype.Component;

/**
 * Clase Fachada que permite crear el objeto con todos sus componentes
 */


public class CocheFacadeImp implements ICocheFacade{

    /**
     * Método encargado de crear Coche Eléctrico
     * @return cocheElectrico
     */

    public CocheElectrico montarCocheElectrico() {

        CocheElectrico cocheElectrico = new CocheElectrico();
        cocheElectrico.encederBateria();
        cocheElectrico.encenderMotor();
        cocheElectrico.encenderAireAcondicionado();

        return cocheElectrico;

    }
    /**
     * Método encargado de crear Coche Híbrido
     * @return cocheHibrido
     */
    public CocheHibrido montarCocheHibrido() {
        CocheHibrido cocheHibrido = new CocheHibrido();

        cocheHibrido.encenderMotor();
        cocheHibrido.encederBateria();
        cocheHibrido.encenderAireAcondicionado();

        return cocheHibrido;
    }

    /**
     * Método encargado de crear Coche Combustión
     * @return cocheCombustión
     */
    public CocheCombustion montarCocheCombustion() {
        CocheCombustion cocheCombustion = new CocheCombustion();

        cocheCombustion.encederBateria();
        cocheCombustion.encenderMotor();
        cocheCombustion.encenderAireAcondicionado();

        return cocheCombustion;
    }
}
