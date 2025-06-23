package br.edu.fiec.gaming_ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Float total;

    @Column(nullable = false)
    private String mtd_pgm;

    @Column(nullable = false)
    private String endr_entr;

    @Column(nullable = false)
    private String data_pedido;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "fk_cliente_id") //nullable = true
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fk_game_id")
    private Game game;

    public Pedido(String status, Float total, String mtd_pgm, String endr_entr, String data_pedido, Integer quantidade, Cliente cliente, Game game) {
        setStatus(status);
        setTotal(total);
        setMtd_pgm(mtd_pgm);
        setEndr_entr(endr_entr);
        setData_pedido(data_pedido);
        setQuantidade(quantidade);
        setCliente(cliente);
        setGame(game);
    }


}
