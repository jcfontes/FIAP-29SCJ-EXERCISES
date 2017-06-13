package fiap.server;

import java.util.List;

import fiap.dao.impl.PacienteDao;
import fiap.entity.MatMed;
import fiap.entity.Paciente;
import fiap.entity.Procedimento;

public class PacienteServer {

	static PacienteDao pacienteDao;

	public PacienteServer() {
		super();
		pacienteDao = new PacienteDao(Paciente.class);
	}

	public void adicionar(StringBuilder log, Paciente paciente) {
		pacienteDao.adicionar(paciente);
		log.append("Paciente salvo." + "\n");
	}

	public List<Paciente> listar(StringBuilder log) {
		log.append("\n >>> Lista de Pacientes <<< \n");
		List<Paciente> pacientes = pacienteDao.listar();
		for (Paciente paciente : pacientes) {
			log.append("--- Paciente: " + paciente.toString() + "\n");
		}
		return pacientes;
	}

	public Paciente buscar(StringBuilder log, String cpf) {
		log.append("\n >>> Busca Paciente <<< \n");
		try {
			Paciente paciente = pacienteDao.buscar(cpf);
			log.append("--- Paciente: " + paciente.toString() + "\n");
			return paciente;
		}
		catch (Exception e) {
			log.append("--- Paciente nao foi encontrado.\n");
			return null;
		}
	}

	public List<Procedimento> buscarProcedimentos(StringBuilder log, String cpf) {
		log.append("\n >>> Busca Procedimentos Paciente <<< \n");
		try {
			List<Procedimento> procedimentos = pacienteDao.buscarProcedimentos(cpf);
			log.append("--- Procedimentos: " + procedimentos.toString() + "\n");
			return procedimentos;
		}
		catch (Exception e) {
			log.append("--- Paciente nao foi encontrado.\n");
			return null;
		}
	}

	public List<MatMed> buscarMateriais(StringBuilder log, String cpf) {
		log.append("\n >>> Busca Materiais Paciente <<< \n");
		try {
			List<MatMed> materiais = pacienteDao.buscarMateriais(cpf);
			log.append("--- Materiais: " + materiais.toString() + "\n");
			return materiais;
		}
		catch (Exception e) {
			log.append("--- Paciente nao foi encontrado.\n");
			return null;
		}
	}

	public void alterar(StringBuilder log, Paciente paciente) {
		log.append("\n >>> Altera Paciente <<< \n");
		pacienteDao.atualizar(paciente);
		log.append("--- Paciente Atualizado.\n");
	}

	public void remover(StringBuilder log, Paciente paciente) {
		log.append("\n >>> Remove Paciente <<< \n");
		pacienteDao.remover(paciente);
		log.append("--- Paciente Removido.\n");
	}

}
