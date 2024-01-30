package com.cjpm.gestorcoches.factory;


import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;

public interface ICocheFactory {

    CocheElectricoDTO obtenerAutomovilElectrico(CocheElectrico coche);
    CocheHibridoDTO obtenerAutomovilHibrido(CocheHibrido coche);
    CocheCombustionDTO obtenerAutomovilCombustion(CocheCombustion coche);
}
