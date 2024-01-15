package com.cjpm.gestorcoches.facade;

import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;

public interface ICocheFacade {
    CocheElectrico montarCocheElectrico();
    CocheHibrido montarCocheHibrido();
    CocheCombustion montarCocheCombustion();
}
