package com.cjpm.gestorcoches.services;


import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;

import java.util.List;
import java.util.Optional;

public interface ICocheElectricoService {

    //Coche Eléctrico
    CocheElectrico saveCocheElectrico(CocheElectrico cocheElectrico);
    List<CocheElectrico> findAllCocheElectrico();
    Optional<CocheElectrico> findCocheElectricoById(Long id);
    boolean deleteAllCocheElectrico();
    boolean deleteCocheElectricoById(Long id);









}
