package fiap.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fiap.entity.Cliente;
import fiap.entity.Pedido;

public class PedidoFactory {

	public static List<Pedido> criarPedidos(Cliente cliente) {

		Pedido pedido = new Pedido();
		List<Pedido> pedidos = new ArrayList<>();

		pedido.setCliente(cliente);
		pedido.setDescricao("Mochila");
		pedido.setValor(20.00);
		pedido.setData(new Date());

		pedidos.add(pedido);

		pedido.setCliente(cliente);
		pedido.setDescricao("Camera");
		pedido.setValor(2000.00);
		pedido.setData(new Date());

		pedidos.add(pedido);

		return pedidos;
	}

}
