package com.cjpm.gestorcoches.controller;

import com.cjpm.gestorcoches.dto.CocheElectricoDTO;
import com.cjpm.gestorcoches.entities.CocheElectrico;
import com.cjpm.gestorcoches.exception.CocheBadRequestException;
import com.cjpm.gestorcoches.exception.CocheGlobalException;
import com.cjpm.gestorcoches.exception.CocheNoContentException;
import com.cjpm.gestorcoches.exception.CocheNotFoundException;
import com.cjpm.gestorcoches.factory.CocheFactoryImp;
import com.cjpm.gestorcoches.services.CocheElectricoServiceImp;
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
public class CocheElectricoController {
    /**
     * Inyección de las dependencias
     */


    private final CocheElectricoServiceImp cocheElectricoService;
    private final CocheFactoryImp cocheFactory;
    private final DTOConverter dtoConverter;

    @Autowired
    public CocheElectricoController(CocheElectricoServiceImp cocheElectricoService, CocheFactoryImp cocheFactory, DTOConverter dtoConverter) {
        this.cocheElectricoService = cocheElectricoService;
        this.cocheFactory = cocheFactory;
        this.dtoConverter = dtoConverter;
    }


    /**
     * Devuelve todos los coches eléctricos
     * @return ResponseEntity<List<CocheElectricoDTO>>
     */

    @Operation(summary = "Mostrar listado de coches eléctricos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado encontrado",content = {@Content(mediaType="application/json",schema=@Schema(implementation = CocheElectricoDTO.class))}),
            @ApiResponse(responseCode = "204", description = "Lista devuelta vacía", content = @Content)
    })
    @GetMapping("/coches_electricos")
    public ResponseEntity<List<CocheElectricoDTO>> findAll(){
        List<CocheElectrico> listaCochesElectricos = cocheElectricoService.findAllCocheElectrico();

        if(listaCochesElectricos==null || listaCochesElectricos.isEmpty()){
            throw new CocheNoContentException("La lista está vacía");
        }

        return new ResponseEntity<>(
                listaCochesElectricos.stream()
                .map(cocheFactory::obtenerAutomovilElectrico)
                .collect(Collectors.toList()),
                HttpStatus.OK);

    }


    /**
     * Devuelve el coche eléctrico que solicita el cliente
     * @param id -
     * @return CocheElectricoDTO
     */

    @Operation(summary = "Mostrar coche eléctrico por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coche encontrado",content = {@Content(mediaType="application/json",schema=@Schema(implementation = CocheElectricoDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Coche no encontrado", content = @Content)
    })
    @GetMapping("/coches_electricos/{id}")
    public ResponseEntity<CocheElectricoDTO> findById(@PathVariable Long id){
        Optional<CocheElectrico> cocheElectricoOpt= cocheElectricoService.findCocheElectricoById(id);

        return new ResponseEntity<>(cocheElectricoOpt
                .map(cocheFactory::obtenerAutomovilElectrico)
                .orElseThrow(()->new CocheNotFoundException("No se ha encontrado el coche con el siguiente id: " + id)),
                HttpStatus.OK);

    }


    /**
     * Método que guarda un coche eléctrico creado
     * @param cocheElectricoDTO -
     * @return ResponseEntity<CocheElectrico>
     */

    @Operation(summary = "Crear coche eléctrico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coche creado",content = {@Content(mediaType="application/json",schema=@Schema(implementation = CocheElectrico.class))}),
            @ApiResponse(responseCode = "500", description = "Coche errónea creado con campo id", content = @Content)
    })
    @PostMapping("/coches_electricos")
    public ResponseEntity<CocheElectrico> createCocheElectrico(@RequestBody CocheElectricoDTO cocheElectricoDTO) throws ParseException {

        CocheElectrico cocheElectrico = dtoConverter.convertDTOToEntity(cocheElectricoDTO, CocheElectrico.class);
        if(cocheElectrico.getIdCoche()!=0){
            throw new CocheGlobalException("El campo del id debe estar vacío");
        }

        return ResponseEntity.ok(cocheElectricoService.saveCocheElectrico(cocheElectrico));

    }


    /**
     * Actualizar coche eléctrico
     * @param cocheElectricoDTO -
     * @return ResponseEntity<CocheElectrico>
     */
    @Operation(summary = "Actualizar coche eléctrico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coche actualizado y, si no existe, coche nuevo creado",content = {@Content(mediaType="application/json",schema=@Schema(implementation = CocheElectricoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "No se ha podido llevar a cabo la actualización", content = @Content)
    })
    @PutMapping("/coches_electricos")
    public ResponseEntity<CocheElectricoDTO> updateCocheElectrico(@RequestBody CocheElectricoDTO cocheElectricoDTO){
        if(cocheElectricoDTO.getIdCoche()==0){
            throw new CocheBadRequestException("No se ha podido atender la petición de actualización");
        }

        CocheElectrico cocheElectrico = dtoConverter.convertDTOToEntity(cocheElectricoDTO, CocheElectrico.class);
        cocheElectricoService.saveCocheElectrico(cocheElectrico);
        return ResponseEntity.ok(dtoConverter.convertEntityToDTO(cocheElectrico, CocheElectricoDTO.class));
    }

    //Eliminar coche eléctrico determinado

    /**
     * Eliminar coche eléctrico determinado
     *
     * @param id - id del coche eléctrico
     * @return ResponseEntity<CocheElectrico>
     */
    @Operation(summary = "Eliminar coche eléctrico por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Coche borrado correctamente",content = @Content),
            @ApiResponse(responseCode = "404", description = "No se ha encontrado coche con el id solicitado y, por lo tanto, no puede borrarse", content = @Content)
    })
    @DeleteMapping("/coches_electricos/{id}")
    public ResponseEntity<HttpStatus> deleteCocheElectrico(@PathVariable Long id){
        boolean result= cocheElectricoService.deleteCocheElectricoById(id);
        if(result){
            throw new CocheNoContentException("Se ha borrado correctamente el coche con el id: " + id);
        }
        throw new CocheNotFoundException("No se ha encontrado el coche con el id: " + id);
    }

    /**
     * Borrar todos los coches eléctricos
     * @return ResponseEntity<CocheElectrico>
     */
    @Operation(summary = "Eliminar listado de coches eléctricos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Listado borrado correctamente",content = @Content),
            @ApiResponse(responseCode = "500", description = "No se ha podido borrar el listado de coches", content = @Content)
    })
    @DeleteMapping("/coches_electricos")
    public ResponseEntity<HttpStatus>deleteAllCocheElectrico(){
        boolean result= cocheElectricoService.deleteAllCocheElectrico();
        if(result){
            throw new CocheNoContentException("La lista se ha borrado correctamente");
        }
        throw new CocheGlobalException("Error al borrar todos los coches");
    }

}
