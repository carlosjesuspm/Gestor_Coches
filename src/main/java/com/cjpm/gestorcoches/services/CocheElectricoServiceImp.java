package com.cjpm.gestorcoches.services;


import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;
import com.cjpm.gestorcoches.repository.CocheElectricoRepository;

import java.util.List;
import java.util.Optional;

import static com.cjpm.gestorcoches.factory.CocheType.*;

public class CocheElectricoServiceImp implements ICocheElectricoService{

    //Atributos
    private CocheFactoryImp cocheFactory = new CocheFactoryImp();
    private CocheElectricoRepository cocheElectricoRepository;


    //Funciones
    // Crear coche eléctrico nuevo
    public CocheElectrico saveCocheElectrico() {
        return cocheElectricoRepository.save((CocheElectrico)cocheFactory.creadorAutomovil(COCHE_ELECTRICO));
    }
    // Mostrar listado de coches eléctrico

    public List<CocheElectrico> findAllCocheElectrico() {
        return cocheElectricoRepository.findAll();
    }

    // Muestra coche eléctrico determinado

    public Optional<CocheElectrico> findCocheElectricoById(Long id) {

        if(id==null || id<=0){
            return Optional.empty();
        }
        return cocheElectricoRepository.findById(id);

    }


}