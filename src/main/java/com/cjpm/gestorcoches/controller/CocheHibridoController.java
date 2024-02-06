package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.dto.CocheHibridoDTO;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.entities.CocheHibrido;
import com.cjpm.gestorcoches.exception.CocheBadRequestException;
import com.cjpm.gestorcoches.exception.CocheGlobalException;
import com.cjpm.gestorcoches.exception.CocheNoContentException;
import com.cjpm.gestorcoches.exception.CocheNotFoundException;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;
import com.cjpm.gestorcoches.services.CocheHibridoServiceImp;
import com.cjpm.gestorcoches.config.DTOConverter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mostrar listado de coches híbridos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado encontrado",content = {@Content(mediaType="application/json",schema=@Schema(implementation = CocheHibridoDTO.class))}),
            @ApiResponse(responseCode = "204", description = "Lista devuelta vacía", content = @Content)
    })
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
    @Operation(summary = "Mostrar coche híbrido por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coche encontrado",content = {@Content(mediaType="application/json",schema=@Schema(implementation = CocheHibridoDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Coche no encontrado", content = @Content)
    })
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
    @Operation(summary = "Crear coche híbrido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coche creado",content = {@Content(mediaType="application/json",schema=@Schema(implementation = CocheHibrido.class))}),
            @ApiResponse(responseCode = "500", description = "Coche errónea creado con campo id", content = @Content)
    })
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
    @Operation(summary = "Actualizar coche híbrido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coche actualizado y, si no existe, coche nuevo creado",content = {@Content(mediaType="application/json",schema=@Schema(implementation = CocheHibridoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "No se ha podido llevar a cabo la actualización", content = @Content)
    })
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
    @Operation(summary = "Eliminar coche híbrido por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Coche borrado correctamente",content = @Content),
            @ApiResponse(responseCode = "404", description = "No se ha encontrado coche con el id solicitado y, por lo tanto, no puede borrarse", content = @Content)
    })
    @DeleteMapping("/coches_hibridos/{id}")
    public ResponseEntity<HttpStatus> deleteCocheHibrido(@PathVariable Long id){
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
    @Operation(summary = "Eliminar listado de coches híbridos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Listado borrado correctamente",content = @Content),
            @ApiResponse(responseCode = "500", description = "No se ha podido borrar el listado de coches", content = @Content)
    })
    @DeleteMapping("/coches_hibridos")
    public ResponseEntity<HttpStatus> deleteAllCocheHibrido(){
        boolean result = cocheHibridoService.deleteAllCocheHibrido();
        if(result){
            throw new CocheNoContentException("La lista se ha borrado correctamente");
        }
        throw new CocheGlobalException("Error al borrar todos los coches");
    }
}
