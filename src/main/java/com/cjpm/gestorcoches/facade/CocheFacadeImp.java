package com.cjpm.gestorcoches.facade;

import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import org.springframework.stereotype.Component;


@Component
public class CocheFacadeImp implements ICocheFacade{

    /**
     * Monta coche eléctrico
     * @param coche -
     * @return CocheElectricoDTO
     */
    @Override
    public CocheElectricoDTO startCocheElectrico(CocheElectrico coche) {
        CocheElectricoDTO cocheDTO = new CocheElectricoDTO(coche, true);
        cocheDTO.encenderAireAcondicionado();
        cocheDTO.encederBateria();
        cocheDTO.encenderMotor();

        return cocheDTO;
    }

    /**
     * Monta coche Híbrido
     * @param coche -
     * @return CocheHibridoDTO
     */
    @Override
    public CocheHibridoDTO startCocheHibrido(CocheHibrido coche) {
        CocheHibridoDTO cocheDTO = new CocheHibridoDTO(coche, true);
        cocheDTO.encenderAireAcondicionado();
        cocheDTO.encederBateria();
        cocheDTO.encenderMotor();

        return cocheDTO;
    }

    /**
     * Monta coche de combustión
     * @param coche -
     * @return CocheCombustionDTO
     */
    @Override
    public CocheCombustionDTO startCocheCombustion(CocheCombustion coche) {
        CocheCombustionDTO cocheDTO=new CocheCombustionDTO(coche, true);
        cocheDTO.encenderAireAcondicionado();
        cocheDTO.encederBateria();
        cocheDTO.encenderMotor();

        return cocheDTO;
    }

}
