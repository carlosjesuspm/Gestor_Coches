package com.cjpm.gestorcoches.services;

import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;

import java.util.List;

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
    public void crearCocheHibrido() {cocheFactory.creadorAutomovil(COCHE_HIBRIDO);
    }
        // Mostrar listado de coches híbridos
    @Override
    public List<CocheHibrido> getAllCocheHibrido() {
        return null;
    }

        // Muestra coche híbrido determinado
    @Override
    public CocheHibrido getCocheHibridoById(long id) {
        return null;
    }
}
