package br.edu.fiec.gaming_ecommerce.controller;


import br.edu.fiec.gaming_ecommerce.model.entity.Pedido;
import br.edu.fiec.gaming_ecommerce.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createPedido(@RequestBody Pedido pedido) {
        pedidoService.createPedido(pedido);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Pedido> getAll() {
        return pedidoService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "id_pedido", produces = APPLICATION_JSON_VALUE)
    public Pedido getById(@RequestParam Integer id_pedido) {
        return pedidoService.getById(id_pedido);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "status", produces = APPLICATION_JSON_VALUE)
    public Optional<List<Pedido>> getByStatus(String status) {
        return pedidoService.getByStatus(status);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestParam Integer id_pedido) {
        pedidoService.deleteById(id_pedido);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updatePedido(@RequestBody Pedido pedido) {
        pedidoService.updatePedido(pedido);
    }
}
