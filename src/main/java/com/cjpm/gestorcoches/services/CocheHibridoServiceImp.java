package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.repository.CocheHibridoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CocheHibridoServiceImp implements ICocheHibridoService{

    //Atributos

    private CocheHibridoRepository cocheHibridoRepository;

    public CocheHibridoServiceImp() {
    }

    @Autowired
    public CocheHibridoServiceImp(CocheHibridoRepository cocheHibridoRepository) {
        this.cocheHibridoRepository = cocheHibridoRepository;
    }

    //Funciones
        // Crear coche híbrido nuevo

    /**
     * Método encargado de crear y guardar coche híbrido
     * @param cocheHibrido
     * @return CocheHibrido
     */
    public CocheHibrido saveCocheHibrido(CocheHibrido cocheHibrido) {
        return cocheHibridoRepository.save(cocheHibrido);
    }

    /**
     * Método encargado de devolver todos los coches híbridos
     * @return List<CocheHibrido>
     */

        // Mostrar listado de coches híbridos

    @Override
    public List<CocheHibrido> findAllCocheHibrido() {
        return cocheHibridoRepository.findAll();
    }

        // Muestra coche híbrido determinado

    /**
     * Método encargado de devolver un coche híbrido determinado
     * @param id
     * @return Optional<CocheHibrido>
     */
    @Override
    public Optional<CocheHibrido> findCocheHibridoById(Long id) {

        if(id==null || id<=0){
            return Optional.empty();
        }
        return Optional.of(cocheHibridoRepository.findById(id).get());

    }

    /**
     * Elimina todos los coches híbridos
     * @return true
     */

    @Override
    public boolean deleteAllCocheHibrido() {
        cocheHibridoRepository.deleteAll();
        return true;
    }

    /**
     * Elimina determinado coche híbrido
     * @param id
     * @return true
     */
    @Override
    public boolean deleteCocheHibridoById(Long id) {
        if(id==null || !cocheHibridoRepository.existsById(id)){
            return false;
        }
        cocheHibridoRepository.deleteById(id);
        return false;
    }
}
