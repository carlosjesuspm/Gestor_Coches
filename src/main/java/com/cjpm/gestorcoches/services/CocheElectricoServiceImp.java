package com.cjpm.gestorcoches.services;


import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;

import java.util.List;
import java.util.Optional;

import static com.cjpm.gestorcoches.factory.CocheType.*;

public class CocheElectricoServiceImp implements ICocheElectricoService{

    //Atributos
    private CocheFactoryImp cocheFactory = new CocheFactoryImp();



    //Constructores
    public CocheElectricoServiceImp() {
    }

    public CocheElectricoServiceImp(CocheFactoryImp cocheFactory) {
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
    // Crear coche eléctrico nuevo
    public CocheHibrido saveCocheElectrico() { cocheFactory.creadorAutomovil(COCHE_ELECTRICO);
    }
    // Mostrar listado de coches eléctrico

    public List<CocheHibrido> findAllCocheElectrico() {
        return null;
    }

    // Muestra coche eléctrico determinado

    public Optional<CocheHibrido> findCocheHibridoById(Long id) {
        return null;
    }


}