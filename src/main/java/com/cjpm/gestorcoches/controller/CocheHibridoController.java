package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.services.CocheHibridoServiceImp;
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
     * @param id - id del coche híbrido
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

    /**
     * Método que guarda un coche creado
     * @return ResponseEntity
     */
    @PostMapping("/coches_hibridos")
    public ResponseEntity<CocheHibridoDTO> saveCocheHibrido(@RequestBody CocheHibridoDTO cocheHibridoDTO){
        CocheHibrido cocheHibrido= dtoConverter.convertDTOToEntity(cocheHibridoDTO, CocheHibrido.class);
        if(cocheHibrido.getIdCoche()!=1L) {
            throw new IllegalArgumentException("El id de este coche híbrido ya está empleado");
        }
        cocheHibridoService.saveCocheHibrido(cocheHibrido);
        return ResponseEntity.ok(dtoConverter.convertEntityToDTO(cocheHibrido, CocheHibridoDTO.class));

    }

    /**
     * Actualizar coche híbrido
     * @param cocheHibridoDTO -
     * @return ResponseEntity<CocheHibridoDTO>
     * @throws ParseException -
     */
    @PutMapping("/coches_hibridos")
    public ResponseEntity<CocheHibridoDTO> updateCocheHibrido(@RequestBody CocheHibridoDTO cocheHibridoDTO) throws ParseException{
        if(cocheHibridoDTO.getIdCoche()!=1L) {
            throw new IllegalArgumentException("El id de este coche híbrido ya está empleado");
        }
        CocheHibrido cocheHibrido= dtoConverter.convertDTOToEntity(cocheHibridoDTO, CocheHibrido.class);
        cocheHibridoService.saveCocheHibrido(cocheHibrido);
        return ResponseEntity.ok(dtoConverter.convertEntityToDTO(cocheHibrido, CocheHibridoDTO.class));

    }

    /**
     * Eliminar coche híbrido determinado
     * @param id - id del coche híbrido
     * @return ResponseEntity<CocheHibrido>
     */
    @DeleteMapping("/coches_hibridos/{id}")
    public ResponseEntity<CocheHibrido> deleteCocheHibrido(@PathVariable Long id){
        boolean result=cocheHibridoService.deleteCocheHibridoById(id);
        if(result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    /**
     * Borrar todos los coches híbridos
     * @return ResponseEntity<CocheHibrido>
     */
    @DeleteMapping("/coches_hibridos")
    public ResponseEntity<CocheHibrido> deleteAllCocheHibrido(){
        boolean result = cocheHibridoService.deleteAllCocheHibrido();
        if(result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.internalServerError().build();
    }
}
