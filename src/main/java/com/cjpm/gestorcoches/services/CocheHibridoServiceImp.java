package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;
import com.cjpm.gestorcoches.repository.CocheHibridoRepository;

import java.util.List;
import java.util.Optional;

import static com.cjpm.gestorcoches.factory.CocheType.COCHE_HIBRIDO;

public class CocheHibridoServiceImp implements ICocheHibridoService{

    //Atributos
    private CocheFactoryImp cocheFactory = new CocheFactoryImp();

    private CocheHibridoRepository cocheHibridoRepository;

    //Funciones
        // Crear coche híbrido nuevo


    @Override
    public CocheHibrido saveCocheHibrido() {
        return cocheHibridoRepository.save((CocheHibrido) cocheFactory.creadorAutomovil(COCHE_HIBRIDO));
    }

    // Mostrar listado de coches híbridos
    @Override
    public List<CocheHibrido> findAllCocheHibrido() {

        return cocheHibridoRepository.findAll();
    }

        // Muestra coche híbrido determinado
    @Override
    public Optional<CocheHibrido> findCocheHibridoById(Long id) {

        if(id==null || id<=0){
            return Optional.empty();
        }
        return cocheHibridoRepository.findById(id);

    }
}
