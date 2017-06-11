package fiap.app;

import java.util.List;

import fiap.entity.Cliente;
import fiap.server.ClienteServer;

public class ClienteApp {

	public static void main(String[] args) {

		ClienteServer clienteServer = new ClienteServer();
		StringBuilder log = new StringBuilder();

		// ADICIONAR CLIENTE
		clienteServer.adicionar(log, 5);

		// LISTAR CLIENTE
		List<Cliente> clientes = clienteServer.listar(log);

		// BUSCAR CLIENTE
		int id = clientes.get(0).getId();
		Cliente cliente = clienteServer.buscar(log, id);

		// ALTERAR CLIENTE
		cliente.setNome("Cliente Alterado");
		clienteServer.alterar(log, cliente);
		Cliente clienteAlterado = clienteServer.buscar(log, cliente.getId());

		// REMOVER CLIENTE
		clienteServer.remover(log, clienteAlterado);
		clienteServer.buscar(log, clienteAlterado.getId());
		System.out.println(log.toString());
	}

}
