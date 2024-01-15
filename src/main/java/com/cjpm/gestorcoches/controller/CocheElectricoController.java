package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.services.CocheElectricoServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CocheElectricoController {
    /**
     * Inyección de las dependencias
     */

    @Autowired
    private CocheElectricoServiceImp cocheElectricoService = new CocheElectricoServiceImp();

    @Autowired
    private ModelMapper modelMapper;



    /**
     * Devuelve todos los coches eléctricos
     * @return CocheElectricoDTO
     */
    @GetMapping("/coches_electricos")
    public List<CocheElectrico> findAll(){
        List<CocheElectricoDTO> listaCochesElectricos = cocheElectricoService.getAllCocheElectrico();

        return listaCochesElectricos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    /**
     * Devuelve el coche eléctrico que solicita el cliente
     * @param id
     * @return CocheElectricoDTO
     */
    @GetMapping("/coches_electricos/{id}")
    public ResponseEntity<CocheElectrico> findById(@PathVariable long id){
        return null;
    }









}
