package fiap.server;

import java.util.List;

import fiap.dao.impl.GenericDao;
import fiap.entity.Pedido;
import fiap.factory.PedidoFactory;

public class PedidoServer {

	static GenericDao<Pedido> pedidoDao;

	public PedidoServer() {
		super();
		PedidoServer.pedidoDao = new GenericDao<>(Pedido.class);
	}

	public void adicionar(StringBuilder log, int qtdPedido) {

		log.append("\n >>> Cria Pedido <<< \n");

		List<Pedido> pedidos = PedidoFactory.criarPedidos(null, 5);

		for (Pedido pedido : pedidos) {
			pedidoDao.adicionar(pedido);
			log.append("Pedido salvo." + "\n");
		}
	}

	public List<Pedido> listar(StringBuilder log) {
		log.append("\n >>> Lista de Pedidos <<< \n");
		List<Pedido> pedidos = pedidoDao.listar();
		for (Pedido pedido : pedidos) {
			log.append("--- Pedido: " + pedido.toString() + "\n");
		}
		return pedidos;
	}

	public Pedido buscar(StringBuilder log, int id) {
		log.append("\n >>> Busca Pedido <<< \n");
		Pedido pedido = pedidoDao.buscar(id);
		if (pedido == null) {
			log.append("--- Pedido nao foi encontrado.\n");
		} else {
			log.append("--- Pedido: " + pedido.toString() + "\n");
		}
		return pedido;
	}

	public void alterar(StringBuilder log, Pedido pedido) {
		log.append("\n >>> Altera Pedido <<< \n");
		pedidoDao.atualizar(pedido);
		log.append("--- Pedido Atualizado.\n");
	}

	public void remover(StringBuilder log, Pedido pedido) {
		log.append("\n >>> Remove Pedido <<< \n");
		pedidoDao.remover(pedido);
		log.append("--- Pedido Removido.\n");
	}

}
