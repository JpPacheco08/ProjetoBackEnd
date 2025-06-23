package br.edu.fiec.gaming_ecommerce.service;

import br.edu.fiec.gaming_ecommerce.model.dto.ClienteDTO;
import br.edu.fiec.gaming_ecommerce.model.entity.Cliente;
import br.edu.fiec.gaming_ecommerce.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public void createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(
                clienteDTO.getNome(),
                clienteDTO.getCpf(),
                clienteDTO.getTelefone(),
                clienteDTO.getEmail()
        );

        clienteRepository.save(cliente);
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id_cliente) {
        return clienteRepository.findById(id_cliente).orElse(null);
    }

    public Cliente findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf).orElse(null);
    }

    public void deleteCliente(Integer id_cliente) {
        clienteRepository.deleteById(id_cliente);
    }

    public void updateCliente(Integer id_cliente, ClienteDTO clienteDTO) {
        clienteRepository.findById(id_cliente).ifPresent(clienteRetorno -> {
            clienteRetorno.setNome(clienteDTO.getNome());
            clienteRetorno.setCpf(clienteDTO.getCpf());
            clienteRetorno.setTelefone(clienteDTO.getTelefone());
            clienteRetorno.setEmail(clienteDTO.getEmail());

            clienteRepository.save(clienteRetorno);
        });
    }
}
