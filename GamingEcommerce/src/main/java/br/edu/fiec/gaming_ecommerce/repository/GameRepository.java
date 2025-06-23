package br.edu.fiec.gaming_ecommerce.repository;


import br.edu.fiec.gaming_ecommerce.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    Optional<List<Game>> findByGenero(String genero);
}
