package br.edu.fiec.gaming_ecommerce.service;



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

    public void createPedido(Pedido pedido) {
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
