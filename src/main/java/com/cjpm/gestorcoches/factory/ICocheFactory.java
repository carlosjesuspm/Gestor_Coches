package com.cjpm.gestorcoches.factory;

import com.cjpm.gestorcoches.entities.Coche;

public interface ICocheFactory {

    Coche creadorAutomovil(CocheType type);
}
