package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.services.CocheElectricoServiceImp;
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
public class CocheHibridoController {

    /**
     * Inyección de las dependencias
     */

    @Autowired
    private CocheElectricoServiceImp cocheHibridoService;

    @Autowired
    private ModelMapper modelMapper;


    /**
     * Devuelve todos los coches híbridos
     * @return CocheHibridoDTO
     */
    @GetMapping("/coches_hibridos")
    public List<CocheHibrido> findAll(){
        return null;
    }

    /**
     * Devuelve el coche híbrido que solicita el cliente
     * @param id
     * @return CocheHibridoDTO
     */
    @GetMapping("/coches_hibridos/{id}")
    public ResponseEntity<CocheHibrido> findById(@PathVariable long id){
        return null;
    }

}
