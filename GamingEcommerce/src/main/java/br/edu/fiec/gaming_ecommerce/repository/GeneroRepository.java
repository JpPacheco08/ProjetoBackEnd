package br.edu.fiec.gaming_ecommerce.repository;


import br.edu.fiec.gaming_ecommerce.model.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

    Optional<Genero> findByGenero(String genero);
}
