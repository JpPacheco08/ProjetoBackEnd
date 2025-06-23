package br.edu.fiec.gaming_ecommerce.service;


import br.edu.fiec.gaming_ecommerce.model.dto.GeneroDTO;
import br.edu.fiec.gaming_ecommerce.model.entity.Genero;
import br.edu.fiec.gaming_ecommerce.repository.GeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GeneroService {

    private final GeneroRepository generoRepository;

    public void createGenero(GeneroDTO generoDTO) {
        Genero genero = new Genero(
                generoDTO.getGenero()
        );
        generoRepository.save(genero);
    }

    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }

    public void deleteGenero(Integer id) {
        generoRepository.deleteById(id);
    }
}
