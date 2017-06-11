package fiap.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fiap.entity.Cliente;
import fiap.entity.Pedido;

public class PedidoFactory {

	public static List<Pedido> criarPedidos(Cliente cliente, int qtdPedidos) {

		List<Pedido> pedidos = new ArrayList<>();

		for (int i = 0; i < qtdPedidos; i++) {
			Pedido pedido = new Pedido();
			if (cliente != null) {
				pedido.setCliente(cliente);
			}
			pedido.setDescricao("Item " + (int) Math.floor(Math.random() * 100));
			pedido.setValor(Math.floor(Math.random() * 100));
			pedido.setData(new Date());
			pedidos.add(pedido);
		}
		return pedidos;
	}

}
