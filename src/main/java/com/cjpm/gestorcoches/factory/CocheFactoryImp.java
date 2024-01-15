package com.cjpm.gestorcoches.factory;


import com.cjpm.gestorcoches.entities.Coche;
import com.cjpm.gestorcoches.facade.CocheFacadeImp;

public class CocheFactoryImp implements ICocheFactory {

    CocheFacadeImp cocheFacade = new CocheFacadeImp();

    /**
     * Llama a los métodos de la Facade para crear los objetos
     * @param type
     *
     */
    public Coche creadorAutomovil(CocheType type){

        switch(type){
            case COCHE_COMBUSTION:
                cocheFacade.montarCocheCombustion();

            case COCHE_HIBRIDO:
                cocheFacade.montarCocheHibrido();

            case COCHE_ELECTRICO:
                cocheFacade.montarCocheElectrico();

            default:
                throw new IllegalArgumentException("Tipo de automóvil no existe: " + type);
        }
    }

}
