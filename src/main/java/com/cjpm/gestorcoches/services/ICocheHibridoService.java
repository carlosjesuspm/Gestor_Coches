package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheHibrido;

import java.util.List;
import java.util.Optional;

public interface ICocheHibridoService {

    //Coche Eléctrico
    CocheHibrido saveCocheHibrido();
    List<CocheHibrido> findAllCocheHibrido();
    Optional<CocheHibrido> findCocheHibridoById(Long id);
}
