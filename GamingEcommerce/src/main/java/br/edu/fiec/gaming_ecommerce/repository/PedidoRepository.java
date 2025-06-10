package br.edu.fiec.gaming_ecommerce.repository;


import br.edu.fiec.gaming_ecommerce.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    Optional<List<Pedido>> findByStatus(String status);
}
