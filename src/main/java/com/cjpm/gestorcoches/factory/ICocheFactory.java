package com.cjpm.gestorcoches.factory;

import com.cjpm.gestorcoches.dto.CocheDTO;
import com.cjpm.gestorcoches.entities.Coche;

public interface ICocheFactory {

    CocheDTO obtenerAutomovil(CocheDTO cocheDTO, CocheType type);
}
