package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;

import java.util.List;
import java.util.Optional;

public interface ICocheHibridoService {

    //Coche Eléctrico
    void saveCocheHibrido(CocheFactoryImp cocheFactory);
    List<CocheHibrido> findAllCocheHibrido();
    Optional<CocheHibrido> findCocheHibridoById(Long id);
    void deleteCocheHibrido(CocheHibrido cocheHibrido);
}
