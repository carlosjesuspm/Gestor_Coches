package com.cjpm.gestorcoches.factory;


import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.dto.CocheHibridoDTO;

public interface ICocheFactory {

    CocheElectricoDTO obtenerAutomovilElectrico(CocheElectricoDTO cocheDTO);
    CocheHibridoDTO obtenerAutomovilHibrido(CocheHibridoDTO cocheDTO);
    CocheCombustionDTO obtenerAutomovilCombustion(CocheCombustionDTO cocheDTO);
}
