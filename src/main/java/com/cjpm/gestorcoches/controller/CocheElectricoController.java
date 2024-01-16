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
    private CocheElectricoServiceImp cocheElectricoService = new CocheElectricoServiceImp();

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
     * @param id
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

    @PostMapping("/coches_electricos/save")
    public ResponseEntity<CocheElectricoDTO> create(@RequestBody CocheElectricoDTO cocheElectricoDTO) throws ParseException {

        CocheElectrico cocheElectrico = convertCocheElectricoDTOToEntity(cocheElectricoDTO);
        cocheElectricoService.saveCocheElectrico(cocheElectrico);

        if(cocheElectrico.getIdCocheElectrico() !=1L){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(convertCocheElectricotoDTO(cocheElectrico));

    }


    private CocheElectricoDTO convertCocheElectricotoDTO(CocheElectrico cocheElectrico){
        CocheElectricoDTO cocheElectricoDTO = modelMapper.map(cocheElectrico, CocheElectricoDTO.class);
        return cocheElectricoDTO;
    }

    private CocheElectrico convertCocheElectricoDTOToEntity(CocheElectricoDTO cocheElectricoDTO) throws ParseException{
        CocheElectrico cocheElectrico = modelMapper.map(cocheElectricoDTO, CocheElectrico.class);

        return cocheElectrico;
    }




}
