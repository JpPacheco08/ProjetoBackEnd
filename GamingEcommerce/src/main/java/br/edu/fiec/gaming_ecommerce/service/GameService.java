package br.edu.fiec.gaming_ecommerce.service;


import br.edu.fiec.gaming_ecommerce.model.dto.GameDTO;
import br.edu.fiec.gaming_ecommerce.model.entity.Estoque;
import br.edu.fiec.gaming_ecommerce.model.entity.Game;
import br.edu.fiec.gaming_ecommerce.model.entity.Genero;
import br.edu.fiec.gaming_ecommerce.repository.EstoqueRepository;
import br.edu.fiec.gaming_ecommerce.repository.GameRepository;
import br.edu.fiec.gaming_ecommerce.repository.GeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    private final GeneroRepository generoRepository;

    private final EstoqueRepository estoqueRepository;

    private final EstoqueService estoqueService;

    public void createGame(GameDTO gameDTO) {
        Optional<Genero> generoOpt = generoRepository.findByGenero(gameDTO.getGenero());

        Estoque estoque = estoqueService.findById(estoqueRepository.get);

        if (generoOpt.isPresent()) {
            Game game = new Game(
                    gameDTO.getNome(),
                    gameDTO.getGenero(),
                    gameDTO.getDescricao(),
                    gameDTO.getValor(),
                    gameDTO.getPlataforma(),
                    estoque
            );
            gameRepository.save(game);

        } else {
            throw new IllegalArgumentException("Gênero não encontrado: " + gameDTO.getGenero());
        }
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

    public void updateGame(Integer id, GameDTO gameDTO) {
        gameRepository.findById(id).ifPresent(gameRetorno -> {
            gameRetorno.setNome(gameDTO.getNome());
            gameRetorno.setGenero(gameDTO.getGenero());
            gameRetorno.setDescricao(gameDTO.getDescricao());
            gameRetorno.setValor(gameDTO.getValor());
            gameRetorno.setPlataforma(gameDTO.getPlataforma());
            gameRepository.save(gameRetorno);
        });
    }

}
