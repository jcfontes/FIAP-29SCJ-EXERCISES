package fiap.helper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fiap.entity.Cliente;
import fiap.entity.Pedido;

public class ClienteHelper {
	private EntityManager em;

	public ClienteHelper(EntityManager em) {
		this.em = em;
	}

	public Cliente salvar(Cliente cliente) {
		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Cliente buscarCliente(int idCliente){ 
		TypedQuery<Cliente> typedQuery = em.createQuery("select c from Cliente c where c.id = :idCliente", Cliente.class);
		typedQuery.setParameter("idCliente", idCliente); 
		return typedQuery.getSingleResult();
	}

	public List<Cliente> listarClientes(){
		TypedQuery<Cliente> typedQuery = em.createQuery("select c from Cliente c", Cliente.class); 
		return typedQuery.getResultList();
	}

	public Cliente adicionarPedidos(int idCliente, List<Pedido> pedidos) {
		try {
			Cliente cliente = em.find(Cliente.class, idCliente);
			if (cliente.getPedidos() == null) {
				cliente.setPedidos(new ArrayList<>());
			}
			for (Pedido pedido : pedidos) {
				pedido.setCliente(cliente);
				cliente.getPedidos().addAll(pedidos);
			}
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}