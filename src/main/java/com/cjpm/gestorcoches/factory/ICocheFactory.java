package com.cjpm.gestorcoches.factory;

import com.cjpm.gestorcoches.dto.CocheDTO;

public interface ICocheFactory {

    CocheDTO creadorAutomovil(CocheType type);
}
