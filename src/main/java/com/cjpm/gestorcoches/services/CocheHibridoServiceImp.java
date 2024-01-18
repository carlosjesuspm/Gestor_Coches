package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;
import com.cjpm.gestorcoches.repository.CocheHibridoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.cjpm.gestorcoches.factory.CocheType.COCHE_HIBRIDO;

@Service
public class CocheHibridoServiceImp implements ICocheHibridoService{

    //Atributos
    private CocheFactoryImp cocheFactory = new CocheFactoryImp();

    @Autowired
    private CocheHibridoRepository cocheHibridoRepository;

    //Funciones
        // Crear coche híbrido nuevo


    @Override
    public void saveCocheHibrido(CocheFactoryImp cocheFactory) {
        cocheHibridoRepository.save((CocheHibrido) cocheFactory.creadorAutomovil(COCHE_HIBRIDO));
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
        return Optional.of(cocheHibridoRepository.findById(id).get());

    }

    @Override
    public void deleteCocheHibrido(CocheHibrido cocheHibrido) {
        cocheHibridoRepository.delete(cocheHibrido);
    }
}
