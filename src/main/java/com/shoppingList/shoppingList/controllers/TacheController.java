package com.shoppingList.shoppingList.controllers;

import com.shoppingList.shoppingList.entities.Course;
import com.shoppingList.shoppingList.entities.Tache;
import com.shoppingList.shoppingList.services.TacheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tache")
public class TacheController {

    private final TacheService tacheService;

    public TacheController(TacheService tacheService) {

        this.tacheService = tacheService;
    }

        @Operation(summary = "creer une tache", description = "Creer une tache ")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Tache Cree",
                        content = {@Content(mediaType = "application/json",
                                schema = @Schema(implementation = Tache.class))}),
                @ApiResponse(responseCode = "400", description = "la tache existe deja.",
                        content = {@Content(mediaType = "application/json",
                                schema = @Schema(implementation = Error.class))})
        })

        @PostMapping
        public Tache createTache(@RequestBody @Valid Tache tache) {
            return tacheService.create(tache);
        }

    @Operation(summary = "obtenir une tache", description = "Obtenir une tache a partir de son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tache",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Tache.class))}),
            @ApiResponse(responseCode = "4004", description = "nous ne retrouvons aucune tache a partir de cet identifiant.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})
    })
    @GetMapping("/{id}")
    public Tache getOne(@PathVariable("id") Long id) {
        return tacheService.getOne(id);
    }


    @Operation(summary = "Modifier une tache", description = "Modifier une tache a partir de son identifianr")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tache Modifiée",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Tache.class))}),
            @ApiResponse(responseCode = "404", description = "Nous ne retrouvons pas la tache a partir de cette identifiant.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})

    })
    @PutMapping("/{id}")
    public Tache updateCourse(@RequestBody @Valid Tache tache, @PathVariable Long id) {
        return tacheService.update(tache,id);
    }

    @Operation(summary = "Lister les taches", description = "Recuperer la liste de toutes les taches")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des taches",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Tache.class)))})

    })
    @GetMapping("/all")
    public List<Tache> tacheList(){
        return tacheService.findAll();
    }

    @Operation(summary = "Supprimer une tache", description = " supprimer une tache a partir de son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tache suppimée avec succes"),
            @ApiResponse(responseCode = "404", description = "Nous ne trouvons pas la tache avec cet idenfiant.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))})
    })
    @DeleteMapping("/{id}")
    public void deleteTacheById(@PathVariable("id") Long id) {
        tacheService.delete(id);
    }

    }

