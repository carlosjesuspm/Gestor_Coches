package com.cjpm.gestorcoches.facade;

import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;

public interface ICocheFacade {
    CocheElectricoDTO montarCocheElectrico();
    CocheHibrido montarCocheHibrido();
    CocheCombustionDTO montarCocheCombustion();
}
