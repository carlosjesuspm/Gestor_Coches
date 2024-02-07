package com.cjpm.gestorcoches.services;


import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.repository.CocheElectricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheElectricoServiceImp implements ICocheElectricoService{

    //Atributos

    private final CocheElectricoRepository cocheElectricoRepository;


    @Autowired
    public CocheElectricoServiceImp(CocheElectricoRepository cocheElectricoRepository) {
        this.cocheElectricoRepository = cocheElectricoRepository;
    }

    //Funciones
    // Crear coche eléctrico nuevo

    /**
     * Método encargado de crear y guardar coche eléctrico
     * @param cocheElectrico -
     * @return CocheElectrico
     */
    public CocheElectrico saveCocheElectrico(CocheElectrico cocheElectrico) {
        return cocheElectricoRepository.save(cocheElectrico);
    }


    // Mostrar listado de coches eléctrico
    /**
     * Método encargado de devolver todos los coches eléctricos
     * @return List<CocheElectrico>
     */
    public List<CocheElectrico> findAllCocheElectrico() {
        return cocheElectricoRepository.findAll();
    }


    // Muestra coche eléctrico determinado
    /**
     * Método encargado de devolver un coche eléctrico determinado
     * @param id -
     * @return Optional<CocheElectrico>
     */
    public Optional<CocheElectrico> findCocheElectricoById(Long id) {

        if(id==null || id<=0){
            return Optional.empty();
        }
        return cocheElectricoRepository.findById(id);

    }

    // Eliminar todos los coches eléctricos
    /**
     * Método encargado de eliminar todos los coches eléctricos
     * @return true
     */
    @Override
    public boolean deleteAllCocheElectrico() {
        cocheElectricoRepository.deleteAll();
        return true;
    }

    //Eliminar coche eléctrico por id

    /**
     * Elimina determinado coche eléctrico
     * @param id -
     * @return true
     */

    @Override
    public boolean deleteCocheElectricoById(Long id) {
        if(id==null || !cocheElectricoRepository.existsById(id)){
            return false;
        }
        cocheElectricoRepository.deleteById(id);
        return true;
    }
}