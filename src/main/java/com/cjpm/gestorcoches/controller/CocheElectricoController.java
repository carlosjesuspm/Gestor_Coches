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

    @Autowired
    private final CocheElectricoServiceImp cocheElectricoService = new CocheElectricoServiceImp();

    @Autowired
    private ModelMapper modelMapper;



    /**
     * Devuelve todos los coches eléctricos
     * @return CocheElectricoDTO
     */
    @GetMapping("/coches_electricos")
    public List<CocheElectricoDTO> findAll(){
        List<CocheElectrico> listaCochesElectricos = cocheElectricoService.findAllCocheElectrico();

        return listaCochesElectricos.stream()
                .map(this::convertCocheElectricotoDTO)
                .collect(Collectors.toList());

    }


    /**
     * Devuelve el coche eléctrico que solicita el cliente
     * @return CocheElectricoDTO
     */
    @GetMapping("/coche_electrico/{id}")
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

    @PostMapping("/save")
    public ResponseEntity<CocheElectricoDTO> saveCocheElectrico(@RequestBody CocheElectricoDTO cocheElectricoDTO) throws ParseException {

        CocheElectrico cocheElectrico = convertCocheElectricoDTOToEntity(cocheElectricoDTO);
        cocheElectricoService.saveCocheElectrico(cocheElectrico);

        if(cocheElectrico.getIdCocheElectrico() !=1L){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(convertCocheElectricotoDTO(cocheElectrico));

    }

    @PutMapping("/coches_electricos")
    public ResponseEntity<CocheElectricoDTO> updateCocheElectrico(@RequestBody CocheElectricoDTO cocheElectricoDTO) throws ParseException {
        if(cocheElectricoDTO.getIdCocheElectrico()!=1L){
            return ResponseEntity.badRequest().build();
        }
        CocheElectrico cocheElectrico = convertCocheElectricoDTOToEntity(cocheElectricoDTO);
        cocheElectricoService.saveCocheElectrico(cocheElectrico);
        return ResponseEntity.ok(convertCocheElectricotoDTO(cocheElectrico));
    }

    //Eliminar coche eléctrico
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteCocheElectrico(@PathVariable Long id){
        boolean result= cocheElectricoService.deleteCocheElectricoById(id);
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
    private CocheElectricoDTO convertCocheElectricotoDTO(CocheElectrico cocheElectrico){
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
