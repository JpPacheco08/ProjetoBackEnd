package br.edu.fiec.gaming_ecommerce.service;


import br.edu.fiec.gaming_ecommerce.model.entity.Game;
import br.edu.fiec.gaming_ecommerce.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public void createGame(Game game) {
        gameRepository.save(game);
    }

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public Game getById(Integer id) {
        return gameRepository.findById(id).orElse(null);
    }

    public List<Game> getByGenero(String genero) {
        return gameRepository.findByGenero(genero).orElse(null);
    }

    public void deleteById(Integer id) {
        gameRepository.deleteById(id);
    }

    public void updateGame(Game game) {
        gameRepository.findById(game.getId()).ifPresent(gameRetorno -> {
            gameRetorno.setNome(game.getNome());
            gameRetorno.setGenero(game.getGenero());
            gameRetorno.setDescricao(game.getDescricao());
            gameRetorno.setPlataforma(game.getPlataforma());
            gameRepository.save(gameRetorno);

        });
    }
}
