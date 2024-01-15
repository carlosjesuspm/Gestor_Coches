package com.cjpm.gestorcoches.services;


import com.cjpm.gestorcoches.entities.CocheHibrido;

import java.util.List;
import java.util.Optional;

public interface ICocheElectricoService {

    //Coche Eléctrico
    CocheHibrido saveCocheElectrico();
    List<CocheHibrido> findAllCocheElectrico();
    Optional<CocheHibrido> findCocheElectricoById(Long id);









}
