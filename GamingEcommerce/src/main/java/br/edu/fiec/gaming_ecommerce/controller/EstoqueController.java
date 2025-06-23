package br.edu.fiec.gaming_ecommerce.controller;


import br.edu.fiec.gaming_ecommerce.model.dto.EstoqueDTO;
import br.edu.fiec.gaming_ecommerce.model.entity.Estoque;
import br.edu.fiec.gaming_ecommerce.service.EstoqueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createEstoque(@RequestBody EstoqueDTO estoqueDTO) {
        estoqueService.createEstoque(estoqueDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Estoque> getAll(){
        return estoqueService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "id", produces = APPLICATION_JSON_VALUE)
    public Estoque findById(@RequestParam Integer id_estoque) {
        return estoqueService.findById(id_estoque);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "nome", produces = APPLICATION_JSON_VALUE)
    public List<Estoque> findByNome(String nome) {
        return estoqueService.findByNome(nome);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteEstoque(@RequestParam Integer id_estoque) {
        estoqueService.deleteEstoque(id_estoque);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateEstoque(@RequestBody Integer id_estoque, EstoqueDTO estoqueDTO) {
        estoqueService.updateEstoque(id_estoque, estoqueDTO);
    }
}
