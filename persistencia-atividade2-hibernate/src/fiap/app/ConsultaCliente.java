package fiap.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fiap.entity.Cliente;
import fiap.helper.ClienteHelper;

public class ConsultaCliente {

	public static void main(String[] args) {

		StringBuilder log = new StringBuilder();

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistencia-atividade2-hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ClienteHelper clienteHelper = new ClienteHelper(entityManager);

		CadastroCliente.criarClientes(log, clienteHelper, 5);
		List<Cliente> clientes = clienteHelper.listarClientes();

		log.append("\n >>> Lista de Clientes <<< \n");

		for (Cliente cliente : clientes) {
			log.append("--- Cliente: " + cliente.toString() + "\n");
		}

		log.append("\n >>> Busca Cliente <<< \n");
		Cliente cliente = clienteHelper.buscarCliente(clientes.get(0).getId());
		log.append("--- Cliente: " + cliente.toString() + "\n");

		System.out.println(log.toString());
	}

}
