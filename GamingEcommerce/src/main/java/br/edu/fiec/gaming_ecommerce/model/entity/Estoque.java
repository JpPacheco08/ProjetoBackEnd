package br.edu.fiec.gaming_ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estoque;

    @Column(nullable = false)
    private String nome;

    @Column
    private Integer quantidade;

    public Estoque(String nome, Integer quantidade) {
        setNome(nome);
        setQuantidade(quantidade);
    }
}
