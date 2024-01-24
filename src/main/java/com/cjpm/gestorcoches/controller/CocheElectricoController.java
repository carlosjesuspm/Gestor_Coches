package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.services.CocheElectricoServiceImp;
import com.cjpm.gestorcoches.config.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CocheElectricoController {
    /**
     * Inyección de las dependencias
     */


    private final CocheElectricoServiceImp cocheElectricoService;


    private final DTOConverter dtoConverter;

    @Autowired
    public CocheElectricoController(CocheElectricoServiceImp cocheElectricoService, DTOConverter dtoConverter) {
        this.cocheElectricoService = cocheElectricoService;
        this.dtoConverter = dtoConverter;
    }


    /**
     * Devuelve todos los coches eléctricos
     * @return CocheElectricoDTO
     */
    @GetMapping("/coches_electricos")
    public List<CocheElectricoDTO> findAll(){
        List<CocheElectrico> listaCochesElectricos = cocheElectricoService.findAllCocheElectrico();

        return listaCochesElectricos.stream()
                .map(cocheElectrico->dtoConverter.convertEntityToDTO(listaCochesElectricos,CocheElectricoDTO.class ))
                .collect(Collectors.toList());
    }


    /**
     * Devuelve el coche eléctrico que solicita el cliente
     * @return CocheElectricoDTO
     */
    @GetMapping("/coches_electricos/{id}")
    public ResponseEntity<CocheElectricoDTO> findById(@PathVariable Long id){
        Optional<CocheElectrico> cocheElectricoOpt= cocheElectricoService.findCocheElectricoById(id);

        return cocheElectricoOpt.map(cocheElectrico -> {
                    CocheElectricoDTO cocheElectricoDTO = new CocheElectricoDTO();
                    cocheElectricoDTO.setIdCoche(cocheElectrico.getIdCoche());
                    cocheElectricoDTO.setBateriaElectrica(cocheElectrico.isBateriaElectrica());
                    cocheElectricoDTO.setMarca(cocheElectrico.getMarca());
                    cocheElectricoDTO.setBateria(cocheElectrico.getBateria());
                    cocheElectricoDTO.setModelo(cocheElectrico.getModelo());
                    cocheElectricoDTO.setColor(cocheElectrico.getColor());
                    cocheElectricoDTO.setAireAcondicionado(cocheElectrico.getAireAcondicionado());
                    cocheElectricoDTO.setMotor(cocheElectrico.getMotor());

                    return ResponseEntity.ok(cocheElectricoDTO);

                }).orElseGet(()-> ResponseEntity.notFound().build());


    }

    /**
     * Método que guarda un coche creado
     * @return ResponseEntity
     */

    @PostMapping("/coches_electricos")
    public ResponseEntity<CocheElectricoDTO> saveCocheElectrico(@RequestBody CocheElectricoDTO cocheElectricoDTO) throws ParseException {

        CocheElectrico cocheElectrico = dtoConverter.convertDTOToEntity(cocheElectricoDTO, CocheElectrico.class);
        if(cocheElectrico.getIdCoche() !=1L){
            throw new IllegalArgumentException("El ID del coche eléctrico no es válido para la actualización");
        }
        cocheElectricoService.saveCocheElectrico(cocheElectrico);
        return ResponseEntity.ok(dtoConverter.convertEntityToDTO(cocheElectrico, CocheElectricoDTO.class));

    }

    /**
     * Actualizar coche eléctrico
     * @param cocheElectricoDTO -
     * @return ResponseEntity<CocheElectrico>
     * @throws ParseException -
     */
    @PutMapping("/coches_electricos")
    public ResponseEntity<CocheElectricoDTO> updateCocheElectrico(@RequestBody CocheElectricoDTO cocheElectricoDTO) throws ParseException {
        if(cocheElectricoDTO.getIdCoche()!=1L){
            throw new IllegalArgumentException("El ID del coche eléctrico no es válido para la actualización");
        }

        CocheElectrico cocheElectrico = dtoConverter.convertDTOToEntity(cocheElectricoDTO, CocheElectrico.class);
        cocheElectricoService.saveCocheElectrico(cocheElectrico);
        return ResponseEntity.ok(dtoConverter.convertEntityToDTO(cocheElectrico, CocheElectricoDTO.class));
    }

    //Eliminar coche eléctrico determinado

    /**
     * Eliminar coche eléctrico determinado
     * @param id - id del coche eléctrico
     * @return ResponseEntity<CocheElectrico>
     */
    @DeleteMapping("/coches_electricos/{id}")
    public ResponseEntity<CocheElectrico>deleteCocheElectrico(@PathVariable Long id){
        boolean result= cocheElectricoService.deleteCocheElectricoById(id);
        if(result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    /**
     * Borrar todos los coches eléctricos
     * @return ResponseEntity<CocheElectrico>
     */
    @DeleteMapping("/coches_electricos")
    public ResponseEntity<CocheElectrico>deleteAllCocheElectrico(){
        boolean result= cocheElectricoService.deleteAllCocheElectrico();
        if(result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.internalServerError().build();
    }

}
