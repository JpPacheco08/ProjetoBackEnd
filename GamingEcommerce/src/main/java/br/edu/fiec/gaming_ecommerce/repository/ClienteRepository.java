package br.edu.fiec.gaming_ecommerce.repository;

import br.edu.fiec.gaming_ecommerce.model.dto.ClienteDTO;
import br.edu.fiec.gaming_ecommerce.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByCpf(String cpf);
}
