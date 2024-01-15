package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;

import java.util.List;
import java.util.Optional;

import static com.cjpm.gestorcoches.factory.CocheType.COCHE_HIBRIDO;

public class CocheHibridoServiceImp implements ICocheHibridoService{

    //Atributos
    private CocheFactoryImp cocheFactory = new CocheFactoryImp();

    //Constructores
    public CocheHibridoServiceImp() {
    }

    public CocheHibridoServiceImp(CocheFactoryImp cocheFactory) {
        this.cocheFactory = cocheFactory;
    }


    //Getters y Setters
    public CocheFactoryImp getCocheFactory() {
        return cocheFactory;
    }

    public void setCocheFactory(CocheFactoryImp cocheFactory) {
        this.cocheFactory = cocheFactory;
    }

    //Funciones
        // Crear coche híbrido nuevo
    @Override
    public CocheHibrido saveCocheHibrido() {return (CocheHibrido) cocheFactory.creadorAutomovil(COCHE_HIBRIDO);
    }
        // Mostrar listado de coches híbridos
    @Override
    public List<CocheHibrido> findAllCocheHibrido() {
        return null;
    }

        // Muestra coche híbrido determinado
    @Override
    public Optional<CocheHibrido> findCocheHibridoById(Long id) {
        return null;
    }
}
