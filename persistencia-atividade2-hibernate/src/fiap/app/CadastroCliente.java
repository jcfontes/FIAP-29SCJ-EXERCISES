package fiap.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fiap.entity.Cliente;
import fiap.factory.ClienteFactory;
import fiap.helper.ClienteHelper;

public class CadastroCliente {

	
	public static void main(String[] args) {

		StringBuilder log = new StringBuilder();
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistencia-atividade2-hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		ClienteHelper clienteHelper = new ClienteHelper(entityManager);
		criarClientes(log, clienteHelper, 5);
		System.out.println(log.toString());
	}

	public static void criarClientes(StringBuilder log, ClienteHelper clienteHelper, int qtdCliente) {
		
		log.append("\n >>> Cria Cliente <<< \n");
		
		List<Cliente> clientes = ClienteFactory.criarClientes(qtdCliente);

		for (Cliente cliente : clientes) {
			clienteHelper.salvar(cliente);
			log.append(clienteHelper.salvar(cliente) + "\n");
		}
	}

}
