package fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import fiap.dao.Dao;
import fiap.dao.JpaUtil;
import fiap.entity.Paciente;

public class GenericDao<T> implements Dao<T> {
	private final Class<T> classe;
	protected EntityManager em;

	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void adicionar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}

	@Override
	public void atualizar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public T buscar(String cpf) throws Exception {
		em = JpaUtil.getEntityManager();
		return (T) em.createQuery("From " + classe.getSimpleName() +" Where cpf = :cpf")
		.setParameter("cpf", cpf)
		.getSingleResult();
	}

	@Override
	public T buscar(int id) throws Exception {
		em = JpaUtil.getEntityManager();
		return (T) em.createQuery("From " + classe.getSimpleName() +" Where id = :id")
		.setParameter("id", id)
		.getSingleResult();
	}
}