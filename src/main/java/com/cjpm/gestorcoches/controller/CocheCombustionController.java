package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.config.DTOConverter;
import com.cjpm.gestorcoches.dto.CocheCombustionDTO;
import com.cjpm.gestorcoches.entities.CocheCombustion;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;
import com.cjpm.gestorcoches.services.CocheCombustionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CocheCombustionController {

    /**
     * Inyección de las dependencias
     */


    private final CocheCombustionServiceImp cocheCombustionService;
    private CocheFactoryImp cocheFactory;
    private final DTOConverter dtoConverter;

    @Autowired
    public CocheCombustionController(CocheCombustionServiceImp cocheCombustionService, CocheFactoryImp cocheFactory, DTOConverter dtoConverter) {
        this.cocheCombustionService = cocheCombustionService;
        this.cocheFactory = cocheFactory;
        this.dtoConverter = dtoConverter;
    }


    /**
     * Devuelve todos los coches de combustión
     * @return CocheCombustionDTO
     */

    @GetMapping("/coches_combustion")
    public List<CocheCombustionDTO> findAll(){
        List<CocheCombustion> listaCochesCombustion=cocheCombustionService.findAllCocheCombustion();

        return listaCochesCombustion.stream()
                .map(cocheFactory::obtenerAutomovilCombustion)
                .collect(Collectors.toList());

    }


    /**
     * Devuelve el coche de combustión que solicita el cliente
     * @param id -
     * @return CocheCombustionDTO
     */

    @GetMapping("/coches_combustion/{id}")
    public ResponseEntity<CocheCombustionDTO> findById(@PathVariable long id){
        Optional<CocheCombustion> cocheCombustionOpt= cocheCombustionService.findCocheCombustionById(id);
        if(cocheCombustionOpt.isPresent()){
            return ResponseEntity.ok(cocheCombustionOpt
                    .map(cocheFactory::obtenerAutomovilCombustion).orElse(null));
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Método que guarda un coche de combustión creado
     * @param cocheCombustionDTO -
     * @return ResponseEntity<CocheCombustion>
     */

    @PostMapping("/coches_combustion")
    public ResponseEntity<CocheCombustion> createCocheCombustion(@RequestBody CocheCombustionDTO cocheCombustionDTO) throws ParseException {
        CocheCombustion cocheCombustion=dtoConverter.convertDTOToEntity(cocheCombustionDTO, CocheCombustion.class);
        if(cocheCombustion.getIdCoche()==0){
            throw new IllegalArgumentException("El ID del coche de combustión no es válido");
        }

        return ResponseEntity.ok(cocheCombustionService.saveCocheCombustion(cocheCombustion));
    }




    /**
     * Actulizar coche de combustión
     * @param cocheCombustionDTO -
     * @return ResponseEntity<CocheCombustionDTO>
     */
    @PutMapping("/coches_combustion")
    public ResponseEntity<CocheCombustionDTO> updateCocheCombustion(@RequestBody CocheCombustionDTO cocheCombustionDTO){
        if(cocheCombustionDTO.getIdCoche()!=1L){
            throw new IllegalArgumentException("El ID del coche de combustión no es válido para la actualización");
        }
        CocheCombustion cocheCombustion=dtoConverter.convertDTOToEntity(cocheCombustionDTO, CocheCombustion.class);
        cocheCombustionService.saveCocheCombustion(cocheCombustion);
        return ResponseEntity.ok(dtoConverter.convertEntityToDTO(cocheCombustion, CocheCombustionDTO.class));
    }

    /**
     * Eliminar coche combustión determinado
     * @param id - id del coche de combustión
     * @return ResponseEntity<CocheCombustion>
     */
    @DeleteMapping("/coches_combustion/{id}")
    public ResponseEntity<CocheCombustion> deleteCocheCombustion(@PathVariable Long id){
        boolean result=cocheCombustionService.deleteCocheCombustionById(id);
        if(result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/coches_combustion")
    public ResponseEntity<CocheCombustion> deleteAllCocheCombustion(){
        boolean result = cocheCombustionService.deleteAllCocheCombustion();
        if(result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.internalServerError().build();
    }
}

