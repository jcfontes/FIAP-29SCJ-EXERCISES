package fiap.factory;

import java.util.ArrayList;
import java.util.List;

import fiap.entity.Cliente;

public class ClienteFactory {

	public static List<Cliente> criarClientes(int qtdClientes) {

		List<Cliente> clientes = new ArrayList<>();

		for (int i = 0; i < qtdClientes; i++) {
			Cliente cliente = new Cliente();
			cliente.setNome("Naldo " + (int) Math.floor(Math.random() * 100));
			cliente.setEmail("naldo" + i + "@email.com");
			cliente.setPedidos(PedidoFactory.criarPedidos(cliente));
			clientes.add(cliente);
		}
		return clientes;
	}

}
