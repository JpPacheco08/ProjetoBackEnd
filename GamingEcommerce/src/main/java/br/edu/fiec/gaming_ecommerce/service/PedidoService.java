package br.edu.fiec.gaming_ecommerce.service;



import br.edu.fiec.gaming_ecommerce.model.dto.PedidoDTO;
import br.edu.fiec.gaming_ecommerce.model.entity.Cliente;
import br.edu.fiec.gaming_ecommerce.model.entity.Game;
import br.edu.fiec.gaming_ecommerce.model.entity.Pedido;
import br.edu.fiec.gaming_ecommerce.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    private final ClienteService clienteService;

    private final GameService gameService;


    public void createPedido(PedidoDTO pedidoDTO) {

        Cliente cliente = clienteService.findById(pedidoDTO.getFk_cliente_id());
        Game game = gameService.getById(pedidoDTO.getFk_game_id());

        if(cliente == null){
            throw new IllegalArgumentException("ID do Cliente não encontrado: " + pedidoDTO.getFk_cliente_id());
            }

        Pedido pedido = new Pedido(
                pedidoDTO.getStatus(),
                pedidoDTO.getTotal(),
                pedidoDTO.getMtd_pgm(),
                pedidoDTO.getEndr_entr(),
                pedidoDTO.getData_pedido(),
                pedidoDTO.getQuantidade(),
                cliente,
                game
        );

        pedidoRepository.save(pedido);
    }

    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    public Pedido getById(Integer id_pedido) {
        return pedidoRepository.findById(id_pedido).orElse(null);
    }

    public List<Pedido> getByStatus(String status) {
        return pedidoRepository.findByStatus(status).orElse(null);
    }

    public void deleteById(Integer id_pedido) {
        pedidoRepository.deleteById(id_pedido);
    }

    public void updatePedido(Pedido pedido) {
        pedidoRepository.findById(pedido.getId_pedido()).ifPresent(pedidoRetorno -> {
                pedidoRetorno.setStatus(pedido.getStatus());
                pedidoRetorno.setTotal(pedido.getTotal());
                pedidoRetorno.setMtd_pgm(pedido.getMtd_pgm());
                pedidoRetorno.setEndr_entr(pedido.getEndr_entr());
                pedidoRetorno.setData_pedido(pedido.getData_pedido());
                pedidoRetorno.setQuantidade(pedido.getQuantidade());
                pedidoRepository.save(pedidoRetorno);
                });

    }

}
