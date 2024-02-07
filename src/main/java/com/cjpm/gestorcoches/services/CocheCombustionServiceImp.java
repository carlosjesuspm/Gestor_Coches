package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.repository.CocheCombustionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CocheCombustionServiceImp implements ICocheCombustionService{

    //Atributo


    private final CocheCombustionRepository cocheCombustionRepository;


    @Autowired
    public CocheCombustionServiceImp(CocheCombustionRepository cocheCombustionRepository) {
        this.cocheCombustionRepository = cocheCombustionRepository;
    }
    //Funciones
        //Crear coche

    /**
     * Método encargado de crear y guardar coche de combustión
     * @param cocheCombustion -
     * @return CocheCombustion
     */
    public CocheCombustion saveCocheCombustion(CocheCombustion cocheCombustion) {
        return cocheCombustionRepository.save(cocheCombustion);
    }


        // Mostrar todos los coches de Combustión

    /**
     * Método encargado de devolver todos los coches de combustión
     * @return List<CocheCombustion>
     */
    @Override
    public List<CocheCombustion> findAllCocheCombustion() {
        return cocheCombustionRepository.findAll();
    }

        // Obtener determinado coche de combustión

    /**
     * Método encargado de devolver un coche de combustión determinado
     * @param id - id del coche de combustión
     * @return Optional<CocheCombustion>
     */
    @Override
    public Optional<CocheCombustion> findCocheCombustionById(Long id) {

        if(id==null || id<=0){
            return Optional.empty();
        }
        return cocheCombustionRepository.findById(id);

    }


        // Eliminar todos los coches de combustión
    /**
     * Método encargado de eliminar todos los coches de combustión
     * @return true
     */
    @Override
    public boolean deleteAllCocheCombustion() {
        cocheCombustionRepository.deleteAll();
        return true;
    }

        // Eliminar coche de combustión determinado

    /**
     * Elimina determinado coche de combustión
     * @param id -
     * @return true
     */
    public boolean deleteCocheCombustionById(Long id){
        if(id==null || !cocheCombustionRepository.existsById(id)){
            return false;
        }
        cocheCombustionRepository.deleteById(id);
        return true;
    }
}
