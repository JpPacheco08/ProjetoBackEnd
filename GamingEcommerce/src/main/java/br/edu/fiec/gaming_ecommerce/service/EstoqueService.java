package br.edu.fiec.gaming_ecommerce.service;

import br.edu.fiec.gaming_ecommerce.model.dto.EstoqueDTO;
import br.edu.fiec.gaming_ecommerce.model.entity.Estoque;
import br.edu.fiec.gaming_ecommerce.repository.EstoqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public void createEstoque(EstoqueDTO estoqueDTO) {
        Estoque estoque = new Estoque(
                estoqueDTO.getNome(),
                estoqueDTO.getQuantidade()
        );

        estoqueRepository.save(estoque);
    }

    public List<Estoque> getAll(){
        return estoqueRepository.findAll();
    }

    public Estoque findById(Integer id_estoque) {
        return estoqueRepository.findById(id_estoque).orElse(null);
    }

    public List<Estoque> findByNome(String nome) {
        return estoqueRepository.findByNome(nome).orElse(null);
    }

    public Estoque findByQuantidade(int quantidade) {
        return estoqueRepository.findByQuantidade(quantidade);
    }

    public void deleteEstoque(Integer id_estoque) {
        estoqueRepository.deleteById(id_estoque);
    }

    public void updateEstoque(Integer id_estoque, EstoqueDTO estoqueDTO) {
        estoqueRepository.findById(id_estoque).ifPresent(estoqueRetorno-> {
            estoqueRetorno.setQuantidade(estoqueDTO.getQuantidade());
        });
    }

}
