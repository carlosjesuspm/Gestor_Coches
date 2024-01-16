package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;
import com.cjpm.gestorcoches.repository.CocheCombustionRepository;

import java.util.List;
import java.util.Optional;

import static com.cjpm.gestorcoches.factory.CocheType.COCHE_COMBUSTION;

public class CocheCombustionServiceImp implements ICocheCombustionService{

    //Atributo
    private CocheFactoryImp cocheFactory = new CocheFactoryImp();

    private CocheCombustionRepository cocheCombustionRepository;



    //Funciones
        //Crear coche
    public void saveCocheCombustion(CocheFactoryImp cocheFactory) {
        cocheCombustionRepository.save((CocheCombustion) cocheFactory.creadorAutomovil(COCHE_COMBUSTION));
    }


        // Mostrar todos los coches de Combustión
    @Override
    public List<CocheCombustion> findAllCocheCombustion() {
        return cocheCombustionRepository.findAll();
    }

        // Obtener determinado coche de combustión
    @Override
    public Optional<CocheCombustion> findCocheCombustionById(Long id) {

        if(id==null || id<=0){
            return Optional.empty();
        }
        return Optional.of(cocheCombustionRepository.findById(id).get());

    }

    @Override
    public void deleteCocheCombustion(CocheCombustion cocheCombustion) {
        cocheCombustionRepository.delete(cocheCombustion);
    }
}
