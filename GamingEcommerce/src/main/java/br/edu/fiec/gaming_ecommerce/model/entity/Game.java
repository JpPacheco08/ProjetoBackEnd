package br.edu.fiec.gaming_ecommerce.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Game  {

    @Id
    private Integer id;

    private String nome;

    private String genero;

    private String descricao;

    private String plataforma;
}
