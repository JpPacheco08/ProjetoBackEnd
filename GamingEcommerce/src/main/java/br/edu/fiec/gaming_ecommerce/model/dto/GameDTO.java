package br.edu.fiec.gaming_ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {

    private String nome;

    private String genero;

    private String descricao;

    private Float valor;

    private String plataforma;
}
