package com.cjpm.gestorcoches.factory;


import com.cjpm.gestorcoches.entities.Coche;
import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.facade.CocheFacadeImp;
import org.springframework.stereotype.Component;

@Component
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
                return (CocheCombustion)cocheFacade.montarCocheCombustion();


            case COCHE_HIBRIDO:
                return (CocheHibrido)cocheFacade.montarCocheHibrido();


            case COCHE_ELECTRICO:
                return (CocheElectrico)cocheFacade.montarCocheElectrico();


            default:
                throw new IllegalArgumentException("Tipo de automóvil no existe: " + type);
        }
    }

}
