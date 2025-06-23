package br.edu.fiec.gaming_ecommerce.controller;


import br.edu.fiec.gaming_ecommerce.model.dto.GameDTO;
import br.edu.fiec.gaming_ecommerce.model.dto.GeneroDTO;
import br.edu.fiec.gaming_ecommerce.model.entity.Genero;
import br.edu.fiec.gaming_ecommerce.service.GeneroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "genero")
public class GeneroController {

    private final GeneroService generoService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createGenero(@RequestBody GeneroDTO generoDTO) {
        generoService.createGenero(generoDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Genero> getAllGeneros() {
        return generoService.getAllGeneros();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteGenero(@RequestParam Integer id) {
        generoService.deleteGenero(id);
    }
}
