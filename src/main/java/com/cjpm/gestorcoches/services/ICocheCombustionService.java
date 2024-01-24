package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheCombustion;

import java.util.List;
import java.util.Optional;

public interface ICocheCombustionService {

    //Coche Combustión
    CocheCombustion saveCocheCombustion(CocheCombustion cocheCombustion);
    List<CocheCombustion> findAllCocheCombustion();
    Optional<CocheCombustion> findCocheCombustionById(Long id);
    boolean deleteAllCocheCombustion();
    boolean deleteCocheCombustionById(Long id);
}
