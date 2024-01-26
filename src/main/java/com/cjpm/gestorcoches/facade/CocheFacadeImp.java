package com.cjpm.gestorcoches.facade;

import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import org.springframework.stereotype.Component;

/**
 * Clase Fachada que permite crear el objeto con todos sus componentes
 */

@Component
public class CocheFacadeImp implements ICocheFacade{

    /**
     * Método encargado de crear Coche Eléctrico
     * @return cocheElectrico
     */

    public CocheDTO startCoche(CocheDTO cocheDTO) {

        cocheDTO.encederBateria();
        cocheDTO.encenderMotor();
        cocheDTO.encenderAireAcondicionado();

        return cocheDTO;

    }

}
