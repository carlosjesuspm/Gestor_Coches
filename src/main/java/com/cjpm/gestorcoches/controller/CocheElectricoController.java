package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.services.CocheElectricoServiceImp;
import org.modelmapper.ModelMapper;
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


    private ModelMapper modelMapper;


    @Autowired
    public CocheElectricoController(CocheElectricoServiceImp cocheElectricoService, ModelMapper modelMapper) {
        this.cocheElectricoService = cocheElectricoService;
        this.modelMapper = modelMapper;
    }

    /**
     * Devuelve todos los coches eléctricos
     * @return CocheElectricoDTO
     */
    @GetMapping("/coches_electricos")
    public List<CocheElectricoDTO> findAll(){
        List<CocheElectrico> listaCochesElectricos = cocheElectricoService.findAllCocheElectrico();

        return listaCochesElectricos.stream()
                .map(this::convertCocheElectricoToDTO)
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
                    cocheElectricoDTO.setIdCocheElectrico(cocheElectrico.getIdCocheElectrico());
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

        CocheElectrico cocheElectrico = convertCocheElectricoDTOToEntity(cocheElectricoDTO);
        if(cocheElectrico.getIdCocheElectrico() !=1L){
            throw new IllegalArgumentException("El ID del coche eléctrico no es válido para la actualización");
        }
        cocheElectricoService.saveCocheElectrico(cocheElectrico);
        return ResponseEntity.ok(convertCocheElectricoToDTO(cocheElectrico));

    }

    /**
     * Actualizar coche eléctrico
     * @param cocheElectricoDTO
     * @return ResponseEntity<CocheElectrico>
     * @throws ParseException
     */
    @PutMapping("/coches_electricos")
    public ResponseEntity<CocheElectricoDTO> updateCocheElectrico(@RequestBody CocheElectricoDTO cocheElectricoDTO) throws ParseException {
        if(cocheElectricoDTO.getIdCocheElectrico()!=1L){
            throw new IllegalArgumentException("El ID del coche eléctrico no es válido para la actualización");
        }

        CocheElectrico cocheElectrico = convertCocheElectricoDTOToEntity(cocheElectricoDTO);
        cocheElectricoService.saveCocheElectrico(cocheElectrico);
        return ResponseEntity.ok(convertCocheElectricoToDTO(cocheElectrico));
    }

    //Eliminar coche eléctrico determinado

    /**
     * Eliminar coche eléctrico determinado
     * @param id
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



    /**
     * Conversión de entidad a DTO
     * @param cocheElectrico
     * @return cocheElectricoDTO
     */
    private CocheElectricoDTO convertCocheElectricoToDTO(CocheElectrico cocheElectrico){
        CocheElectricoDTO cocheElectricoDTO = modelMapper.map(cocheElectrico, CocheElectricoDTO.class);
        return cocheElectricoDTO;
    }

    /**
     * Conversión DTO a entidad
     * @param cocheElectricoDTO
     * @return cocheElectrico
     * @throws ParseException
     */
    private CocheElectrico convertCocheElectricoDTOToEntity(CocheElectricoDTO cocheElectricoDTO) throws ParseException{
        CocheElectrico cocheElectrico = modelMapper.map(cocheElectricoDTO, CocheElectrico.class);

        return cocheElectrico;
    }




}
