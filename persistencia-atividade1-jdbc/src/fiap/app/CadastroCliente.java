package fiap.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fiap.dao.ClienteDAO;
import fiap.dao.PedidoDAO;
import fiap.entity.Cliente;
import fiap.entity.Pedido;

public class CadastroCliente {

	public static void main(String[] args) {

		try {

			System.out.println("Cadastrando Cliente...");
			ClienteDAO clienteDAO = new ClienteDAO();
			PedidoDAO pedidoDAO = new PedidoDAO();

			List<Pedido> pedidos = new ArrayList<>();

			Cliente cliente = new Cliente("Carlos", "carlos@email.com", pedidos);
			cliente = clienteDAO.incluirCliente(cliente);
			System.out.println("Cadastro Finalizado.");

			System.out.println("Cadastrando Pedidos...");
			pedidos.add(new Pedido(cliente.getId(), new Date(), "Pasta", 20.00));
			pedidos.add(new Pedido(cliente.getId(), new Date(), "Mochila", 40.00));

			for (Pedido pedido : pedidos) {
				pedido = pedidoDAO.incluirPedido(pedido);
			}

			System.out.println("Cadastro Finalizado.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
