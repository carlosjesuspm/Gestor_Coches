package com.cjpm.gestorcoches.facade;

import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
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
    @Override
    public CocheElectricoDTO startCocheElectrico(CocheElectrico coche) {
        CocheElectricoDTO cocheDTO = new CocheElectricoDTO(coche, true);
        cocheDTO.encenderAireAcondicionado();
        cocheDTO.encederBateria();
        cocheDTO.encenderMotor();

        return cocheDTO;
    }

    @Override
    public CocheHibridoDTO startCocheHibrido(CocheHibrido coche) {
        CocheHibridoDTO cocheDTO = new CocheHibridoDTO(coche);
        cocheDTO.encenderAireAcondicionado();
        cocheDTO.encederBateria();
        cocheDTO.encenderMotor();

        return cocheDTO;
    }

    @Override
    public CocheCombustionDTO startCocheCombustion(CocheCombustion coche) {
        CocheCombustionDTO cocheDTO=new CocheCombustionDTO(coche);
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
