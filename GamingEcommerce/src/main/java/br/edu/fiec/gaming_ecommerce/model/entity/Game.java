package br.edu.fiec.gaming_ecommerce.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Game  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    private String plataforma;

    @ManyToOne
    @JoinColumn(name = "fk_estoque_id")
    private Estoque estoque;

    public Game(String nome, String genero, String descricao, Float valor, String plataforma, Estoque estoque) {
        setNome(nome);
        setGenero(genero);
        setDescricao(descricao);
        setValor(valor);
        setPlataforma(plataforma);
        setEstoque(estoque);
    }
}
