package fiap.dao.impl;

import java.util.List;

import fiap.dao.JpaUtil;
import fiap.entity.MatMed;
import fiap.entity.Paciente;
import fiap.entity.Procedimento;

public class PacienteDao extends GenericDao<Paciente> {
	
	public PacienteDao(Class<Paciente> classe) {
		super(classe);
	}

	public List<Procedimento> buscarProcedimentos(String cpf) {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From Procedimento Where paciente.cpf = :cpf")
		.setParameter("cpf", cpf)
		.getResultList();
	}

	public List<MatMed> buscarMateriais(String cpf) {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From MatMed Where paciente.cpf = :cpf")
		.setParameter("cpf", cpf)
		.getResultList();
	}

}
