package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import java.util.List;
import java.util.Optional;

public interface ICocheCombustionService {

    //Coche Combustión
    CocheCombustionDTO saveCocheCombustion(CocheCombustionDTO cocheCombustion);
    List<CocheCombustionDTO> findAllCocheCombustion();
    Optional<CocheCombustionDTO> findCocheCombustionById(long id);
}
