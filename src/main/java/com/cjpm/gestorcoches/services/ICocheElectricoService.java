package com.cjpm.gestorcoches.services;


import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;

import java.util.List;
import java.util.Optional;

public interface ICocheElectricoService {

    //Coche Eléctrico
    CocheElectrico saveCocheElectrico();
    List<CocheElectrico> findAllCocheElectrico();
    Optional<CocheElectrico> findCocheElectricoById(Long id);









}
