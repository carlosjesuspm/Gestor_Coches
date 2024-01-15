package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.services.CocheCombustionServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CocheCombustionController {

    /**
     * Inyección de las dependencias
     */

    @Autowired
    private CocheCombustionServiceImp cocheCombustionService = new CocheCombustionServiceImp();

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Devuelve todos los coches de combustión
     * @return CocheCombustionDTO
     */
    @GetMapping("/coches_combustion")
    public List<CocheCombustion> findAll(){
        return null;
    }

    /**
     * Devuelve el coche de combustión que solicita el cliente
     * @param id
     * @return CocheCombustionDTO
     */
    @GetMapping("/coches_combustion/{id}")
    public ResponseEntity<CocheCombustion> findById(@PathVariable long id){
        return null;
    }
}

