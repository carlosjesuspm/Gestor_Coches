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

import static com.cjpm.gestorcoches.factory.CocheType.*;

@Component
public class CocheFactoryImp implements ICocheFactory {

    CocheFacadeImp cocheFacade = new CocheFacadeImp();

    /**
     * Llama a los métodos de la Facade para crear los objetos
     * @param cocheDTO -
     *
     */
    public CocheDTO obtenerAutomovil(CocheDTO cocheDTO, CocheType cocheType){

        return switch (cocheType) {
            case COCHE_COMBUSTION -> (CocheCombustionDTO) cocheFacade.startCoche(cocheDTO);
            case COCHE_HIBRIDO -> (CocheHibridoDTO) cocheFacade.startCoche(cocheDTO);
            case COCHE_ELECTRICO -> (CocheElectricoDTO) cocheFacade.startCoche(cocheDTO);
            default -> throw new IllegalArgumentException("Tipo de automóvil no existe: " + cocheType);
        };
    }

}
