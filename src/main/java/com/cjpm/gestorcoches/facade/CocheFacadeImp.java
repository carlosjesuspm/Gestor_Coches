package com.cjpm.gestorcoches.facade;

import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import org.springframework.stereotype.Component;

/**
 * Clase Fachada que permite crear el objeto con todos sus componentes
 */

@Component
public class CocheFacadeImp implements ICocheFacade{
    @Override
    public CocheElectricoDTO startCocheElectrico(CocheElectricoDTO cocheDTO) {
        cocheDTO.encenderAireAcondicionado();
        cocheDTO.encederBateria();
        cocheDTO.encenderMotor();

        return cocheDTO;
    }

    @Override
    public CocheHibridoDTO startCocheHibrido(CocheHibridoDTO cocheDTO) {
        cocheDTO.encenderAireAcondicionado();
        cocheDTO.encederBateria();
        cocheDTO.encenderMotor();

        return cocheDTO;
    }

    @Override
    public CocheCombustionDTO startCocheCombustion(CocheCombustionDTO cocheDTO) {
        cocheDTO.encenderAireAcondicionado();
        cocheDTO.encederBateria();
        cocheDTO.encenderMotor();

        return cocheDTO;
    }

    /**
     * Método encargado de crear Coche Eléctrico
     * @return cocheElectrico
     */



}
