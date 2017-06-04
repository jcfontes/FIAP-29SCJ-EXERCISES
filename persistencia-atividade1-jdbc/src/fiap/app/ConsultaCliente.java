package fiap.app;

import fiap.dao.impl.mysql.MySQLClienteDAO;
import fiap.dao.impl.mysql.MySQLPedidoDAO;
import fiap.entity.Cliente;
import fiap.entity.Pedido;

public class ConsultaCliente {

	public static void main(String[] args) {

		try {

			System.out.println("Consultando Cliente ...");

			MySQLClienteDAO clienteDAO = new MySQLClienteDAO();
			MySQLPedidoDAO pedidoDAO = new MySQLPedidoDAO();

			Cliente cliente = clienteDAO.buscarCliente(1);

			System.out.println("Cliente " + cliente.getNome() + " " + cliente.getEmail());

			for (Pedido pedido : cliente.getPedidos()) {
				System.out.println(pedido.getDescricao() + " " + pedido.getValor() + " " + pedido.getData());
			}

			System.out.println("Consultando Cliente Finalizado!");
			System.out.println("Consultando Pedido ...");
			Pedido pedido = pedidoDAO.buscarPedido(1);
			System.out.println(pedido.getDescricao() + " " + pedido.getValor() + " " + pedido.getData());
			System.out.println("Consultando Pedido Finalizado!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
