package fiap.app;

import java.util.List;

import fiap.entity.Pedido;
import fiap.server.PedidoServer;

public class PedidoApp {

	public static void main(String[] args) {

		PedidoServer pedidoServer = new PedidoServer();
		StringBuilder log = new StringBuilder();

		// ADICIONAR PEDIDO
		pedidoServer.adicionar(log, 5);

		// LISTAR PEDIDO
		List<Pedido> pedidos = pedidoServer.listar(log);

		// BUSCAR PEDIDO
		int id = pedidos.get(0).getId();
		Pedido pedido = pedidoServer.buscar(log, id);

		// ALTERAR PEDIDO
		pedido.setDescricao("Pedido Alterado");
		pedidoServer.alterar(log, pedido);
		Pedido pedidoAlterado = pedidoServer.buscar(log, pedido.getId());

		// REMOVER PEDIDO
		pedidoServer.remover(log, pedidoAlterado);
		pedidoServer.buscar(log, pedidoAlterado.getId());
		System.out.println(log.toString());
	}

}
