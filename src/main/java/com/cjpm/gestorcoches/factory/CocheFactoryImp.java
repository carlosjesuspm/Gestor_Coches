package com.cjpm.gestorcoches.factory;


import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import com.cjpm.gestorcoches.facade.CocheFacadeImp;
import org.springframework.stereotype.Component;

@Component
public class CocheFactoryImp implements ICocheFactory{

    CocheFacadeImp cocheFacade = new CocheFacadeImp();

    /**
     * Llama a los métodos de la Facade para crear los objetos
     * @param cocheDTO -
     *
     */
    @Override
    public CocheElectricoDTO obtenerAutomovilElectrico(CocheElectricoDTO cocheDTO){
            return cocheFacade.startCocheElectrico(cocheDTO);
        };

    @Override
    public CocheHibridoDTO obtenerAutomovilHibrido(CocheHibridoDTO cocheDTO) {
        return cocheFacade.startCocheHibrido(cocheDTO);
    }

    @Override
    public CocheCombustionDTO obtenerAutomovilCombustion(CocheCombustionDTO cocheDTO) {
        return cocheFacade.startCocheCombustion(cocheDTO);
    }

}

