package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.services.CocheHibridoServiceImp;
import com.cjpm.gestorcoches.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CocheHibridoController {

    /**
     * Inyección de las dependencias
     */


    private final CocheHibridoServiceImp cocheHibridoService;

    private final DTOConverter dtoConverter;

    @Autowired
    public CocheHibridoController(CocheHibridoServiceImp cocheHibridoService, DTOConverter dtoConverter) {
        this.cocheHibridoService = cocheHibridoService;
        this.dtoConverter = dtoConverter;
    }

    /**
     * Devuelve todos los coches híbridos
     * @return CocheHibridoDTO
     */
    @GetMapping("/coches_hibridos")
    public List<CocheHibridoDTO> findAll(){
        List<CocheHibrido> listaCochesHibridos = cocheHibridoService.findAllCocheHibrido();

        return listaCochesHibridos.stream()
                .map(cocheHibrido -> dtoConverter.convertEntityToDTO(listaCochesHibridos, CocheHibridoDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Devuelve el coche híbrido que solicita el cliente
     * @param id
     * @return CocheHibridoDTO
     */
    @GetMapping("/coches_hibridos/{id}")
    public ResponseEntity<CocheHibridoDTO> findById(@PathVariable long id){
        Optional<CocheHibrido> cocheHibridoOpt= cocheHibridoService.findCocheHibridoById(id);

        return cocheHibridoOpt.map(cocheHibrido -> {
            CocheHibridoDTO cocheHibridoDTO = new CocheHibridoDTO();
            cocheHibridoDTO.setIdCoche(cocheHibrido.getIdCoche());
            cocheHibridoDTO.setTanqueHidrogeno(cocheHibrido.isTanqueHidrogeno());
            cocheHibridoDTO.setMarca(cocheHibrido.getMarca());
            cocheHibridoDTO.setBateria(cocheHibrido.getBateria());
            cocheHibridoDTO.setModelo(cocheHibrido.getModelo());
            cocheHibridoDTO.setColor(cocheHibrido.getColor());
            cocheHibridoDTO.setAireAcondicionado(cocheHibrido.getAireAcondicionado());
            cocheHibridoDTO.setMotor(cocheHibrido.getMotor());

            return ResponseEntity.ok(cocheHibridoDTO);

        }).orElseGet(()-> ResponseEntity.notFound().build());
    }

}
