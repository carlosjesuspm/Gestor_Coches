package com.cjpm.gestorcoches.facade;

import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.dto.CocheHibridoDTO;


public interface ICocheFacade {
    CocheElectricoDTO startCocheElectrico(CocheElectricoDTO cocheDTO);
    CocheHibridoDTO startCocheHibrido(CocheHibridoDTO cocheDTO);
    CocheCombustionDTO startCocheCombustion(CocheCombustionDTO cocheDTO);

}
