package com.cjpm.gestorcoches.facade;

import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;

/**
 * Clase Fachada que permite crear el objeto con todos sus componentes
 */
public class CocheFacadeImp implements ICocheFacade{

    /**
     * Método encargado de crear Coche Eléctrico
     * @return cocheElectrico
     */

    public CocheElectricoDTO montarCocheElectrico() {

        CocheElectricoDTO cocheElectrico = new CocheElectricoDTO();
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
    public CocheCombustionDTO montarCocheCombustion() {
        CocheCombustionDTO cocheCombustion = new CocheCombustionDTO();

        cocheCombustion.encederBateria();
        cocheCombustion.encenderMotor();
        cocheCombustion.encenderAireAcondicionado();

        return cocheCombustion;
    }
}
