package br.edu.fiec.gaming_ecommerce.model.dto;

import br.edu.fiec.gaming_ecommerce.model.entity.Cliente;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private String status;

    private Float total;

    private String mtd_pgm;

    private String endr_entr;

    private String data_pedido;

    private Integer quantidade;

    private Integer fk_cliente_id;

    private Integer fk_game_id;
}
