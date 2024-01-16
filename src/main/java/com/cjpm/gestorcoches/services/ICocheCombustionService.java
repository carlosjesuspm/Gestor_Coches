package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;

import java.util.List;
import java.util.Optional;

public interface ICocheCombustionService {

    //Coche Combustión
    void saveCocheCombustion(CocheFactoryImp cocheFactory);
    List<CocheCombustion> findAllCocheCombustion();
    Optional<CocheCombustion> findCocheCombustionById(Long id);
    void deleteCocheCombustion(CocheCombustion cocheCombustion);
}
