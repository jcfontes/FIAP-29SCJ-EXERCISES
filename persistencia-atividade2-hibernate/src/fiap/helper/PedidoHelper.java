package fiap.helper;

import javax.persistence.EntityManager;

import fiap.entity.Pedido;

public class PedidoHelper {
	private EntityManager em;

	public PedidoHelper(EntityManager em){
		this.em = em;
	}

	public String salvar(Pedido pedido) { 
		try {
			em.getTransaction().begin(); 
			em.persist(pedido); 
			em.getTransaction().commit();
			return "Pedido Salvo";
		} catch (Exception e) {
			em.getTransaction().rollback(); 
			throw e;
		} 
	}
}