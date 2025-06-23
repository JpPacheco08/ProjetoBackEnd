package br.edu.fiec.gaming_ecommerce.repository;

import br.edu.fiec.gaming_ecommerce.model.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    Optional<List<Estoque>> findByNome(String nome);
    Estoque findByQuantidade(int quantidade);
}
