package br.edu.fiec.gaming_ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String nome;

    private String cpf;

    private String telefone;

    private String email;

}
