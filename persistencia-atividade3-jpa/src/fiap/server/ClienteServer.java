package fiap.server;

import java.util.List;

import fiap.dao.impl.GenericDao;
import fiap.entity.Cliente;
import fiap.factory.ClienteFactory;

public class ClienteServer {

	static GenericDao<Cliente> clienteDao;

	public ClienteServer() {
		super();
		ClienteServer.clienteDao = new GenericDao<>(Cliente.class);
	}

	public void adicionar(StringBuilder log, int qtdCliente) {

		log.append("\n >>> Cria Cliente <<< \n");

		List<Cliente> clientes = ClienteFactory.criarClientes(qtdCliente);

		for (Cliente cliente : clientes) {
			clienteDao.adicionar(cliente);
			log.append("Cliente salvo." + "\n");
		}
	}

	public List<Cliente> listar(StringBuilder log) {
		log.append("\n >>> Lista de Clientes <<< \n");
		List<Cliente> clientes = clienteDao.listar();
		for (Cliente cliente : clientes) {
			log.append("--- Cliente: " + cliente.toString() + "\n");
		}
		return clientes;
	}

	public Cliente buscar(StringBuilder log, int id) {
		log.append("\n >>> Busca Cliente <<< \n");
		Cliente cliente = clienteDao.buscar(id);
		if (cliente == null) {
			log.append("--- Cliente nao foi encontrado.\n");
		} else {
			log.append("--- Cliente: " + cliente.toString() + "\n");
		}
		return cliente;
	}

	public void alterar(StringBuilder log, Cliente cliente) {
		log.append("\n >>> Altera Cliente <<< \n");
		clienteDao.atualizar(cliente);
		log.append("--- Cliente Atualizado.\n");
	}

	public void remover(StringBuilder log, Cliente cliente) {
		log.append("\n >>> Remove Cliente <<< \n");
		clienteDao.remover(cliente);
		log.append("--- Cliente Removido.\n");
	}

}
