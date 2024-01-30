package com.cjpm.gestorcoches.facade;

import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;


public interface ICocheFacade {
    CocheElectricoDTO startCocheElectrico(CocheElectrico coche);
    CocheHibridoDTO startCocheHibrido(CocheHibrido coche);
    CocheCombustionDTO startCocheCombustion(CocheCombustion coche);

}
