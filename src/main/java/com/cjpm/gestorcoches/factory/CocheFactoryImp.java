package com.cjpm.gestorcoches.factory;


import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.facade.CocheFacadeImp;
import org.springframework.stereotype.Component;

@Component
public class CocheFactoryImp implements ICocheFactory{

    CocheFacadeImp cocheFacade = new CocheFacadeImp();

    /**
     * Llama a los métodos de la Facade para crear los objetos
     * @param coche -
     *
     */
    @Override
    public CocheElectricoDTO obtenerAutomovilElectrico(CocheElectrico coche){
            return cocheFacade.startCocheElectrico(coche);
        };

    @Override
    public CocheHibridoDTO obtenerAutomovilHibrido(CocheHibrido coche) {
        return cocheFacade.startCocheHibrido(coche);
    }

    @Override
    public CocheCombustionDTO obtenerAutomovilCombustion(CocheCombustion coche) {
        return cocheFacade.startCocheCombustion(coche);
    }

}

