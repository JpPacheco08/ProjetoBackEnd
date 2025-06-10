package br.edu.fiec.gaming_ecommerce.controller;


import br.edu.fiec.gaming_ecommerce.model.entity.Game;
import br.edu.fiec.gaming_ecommerce.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "game")
public class GameController {

    private final GameService gameService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void  createGame(@RequestBody Game game) {
        gameService.createGame(game);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Game> getAll(){
        return gameService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "id", produces = APPLICATION_JSON_VALUE)
    public Game getById(@RequestParam Integer id) {
        return gameService.getById(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "genero", produces = APPLICATION_JSON_VALUE)
    public Optional<List<Game>> getByGenero(String genero) {
        return gameService.getByGenero(genero);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestParam Integer id) {
        gameService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateGame(@RequestBody Game game) {
        gameService.updateGame(game);
    }
}
