package br.edu.fiec.gaming_ecommerce.model.entity;


import br.edu.fiec.gaming_ecommerce.repository.PedidoRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    private Integer id_pedido;

    private String status;

    private Float total;

    private String mtd_pgm;

    private String endr_entr;

    private String data_pedido;

    private Integer quantidade;
}
