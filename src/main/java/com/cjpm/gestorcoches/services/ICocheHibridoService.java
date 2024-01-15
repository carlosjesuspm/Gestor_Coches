package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.dto.CocheElectricoDTO;

import java.util.List;
import java.util.Optional;

public interface ICocheHibridoService {

    //Coche Eléctrico
    CocheElectricoDTO saveCocheHibrido();
    List<CocheElectricoDTO> findAllCocheHibrido();
    Optional<CocheElectricoDTO> findCocheHibridoById(Long id);
}
