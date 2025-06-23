package br.edu.fiec.gaming_ecommerce.controller;

import br.edu.fiec.gaming_ecommerce.model.dto.ClienteDTO;
import br.edu.fiec.gaming_ecommerce.model.entity.Cliente;
import br.edu.fiec.gaming_ecommerce.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "cliente")
public class ClienteController {

    private ClienteService clienteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.createCliente(clienteDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "id", produces = APPLICATION_JSON_VALUE)
    public Cliente findById(@RequestParam Integer id_cliente) {
        return clienteService.findById(id_cliente);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "cpf", produces = APPLICATION_JSON_VALUE)
    public Cliente findByCpf(@RequestParam String cpf) {
        return clienteService.findByCpf(cpf);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteCliente(@RequestParam Integer id_cliente) {
        clienteService.deleteCliente(id_cliente);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateCliente(@RequestBody Integer id_cliente, ClienteDTO clienteDTO) {
        clienteService.updateCliente(id_cliente, clienteDTO);
    }
}
