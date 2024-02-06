package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.exception.CocheBadRequestException;
import com.cjpm.gestorcoches.exception.CocheGlobalException;
import com.cjpm.gestorcoches.exception.CocheNoContentException;
import com.cjpm.gestorcoches.exception.CocheNotFoundException;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;
import com.cjpm.gestorcoches.services.CocheHibridoServiceImp;
import com.cjpm.gestorcoches.config.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private final CocheFactoryImp cocheFactory;

    private final DTOConverter dtoConverter;

    @Autowired
    public CocheHibridoController(CocheHibridoServiceImp cocheHibridoService, CocheFactoryImp cocheFactory, DTOConverter dtoConverter) {
        this.cocheHibridoService = cocheHibridoService;
        this.cocheFactory = cocheFactory;
        this.dtoConverter = dtoConverter;
    }


    /**
     * Devuelve todos los coches híbridos
     * @return CocheHibridoDTO
     */

    @GetMapping("/coches_hibridos")
    public ResponseEntity<List<CocheHibridoDTO>> findAll(){
        List<CocheHibrido> listaCochesHibridos = cocheHibridoService.findAllCocheHibrido();

        if(listaCochesHibridos==null||listaCochesHibridos.isEmpty()){
            throw new CocheNoContentException("La lista está vacía");
        }
        return new ResponseEntity<>(listaCochesHibridos.stream()
                .map(cocheFactory::obtenerAutomovilHibrido)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }


    /**
     * Devuelve el coche híbrido que solicita el cliente
     * @param id - id del coche híbrido
     * @return ResponseEntity<CocheHibridoDTO>
     */

    @GetMapping("/coches_hibridos/{id}")
    public ResponseEntity<CocheHibridoDTO> findById(@PathVariable long id){
        Optional<CocheHibrido> cocheHibridoOpt= cocheHibridoService.findCocheHibridoById(id);
        return ResponseEntity.ok(cocheHibridoOpt
                .map(cocheFactory::obtenerAutomovilHibrido)
                .orElseThrow(()->new CocheNotFoundException("No se ha encontrado el coche con el siguiente id: " + id)));
    }


    /**
     * Método que guarda un coche creado
     * @param cocheHibridoDTO -
     * @return ResponseEntity<CocheHibrido>
     * @throws ParseException -
     */

    @PostMapping("/coches_hibridos")
    public ResponseEntity<CocheHibrido> createCocheHibrido(@RequestBody CocheHibridoDTO cocheHibridoDTO) throws ParseException{
        CocheHibrido cocheHibrido= dtoConverter.convertDTOToEntity(cocheHibridoDTO, CocheHibrido.class);
        if(cocheHibrido.getIdCoche()!=0) {
            throw new CocheGlobalException("El campo del id debe estar vacío");
        }
        return ResponseEntity.ok(cocheHibridoService.saveCocheHibrido(cocheHibrido));
    }


    /**
     * Actualizar coche híbrido
     * @param cocheHibridoDTO -
     * @return ResponseEntity<CocheHibridoDTO>
     */
    @PutMapping("/coches_hibridos")
    public ResponseEntity<CocheHibridoDTO> updateCocheHibrido(@RequestBody CocheHibridoDTO cocheHibridoDTO){
        if(cocheHibridoDTO.getIdCoche()==0) {
            throw new CocheBadRequestException("No se ha podido atender la petición de actualización");
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
            throw new CocheNoContentException("Se ha borrado correctamente el coche con el id: " + id);
        }
        throw new CocheNotFoundException("No se ha encontrado el coche con el id: " + id);
    }

    /**
     * Borrar todos los coches híbridos
     * @return ResponseEntity<CocheHibrido>
     */
    @DeleteMapping("/coches_hibridos")
    public ResponseEntity<CocheHibrido> deleteAllCocheHibrido(){
        boolean result = cocheHibridoService.deleteAllCocheHibrido();
        if(result){
            throw new CocheNoContentException("La lista se ha borrado correctamente");
        }
        throw new CocheGlobalException("Error al borrar todos los coches");
    }
}
