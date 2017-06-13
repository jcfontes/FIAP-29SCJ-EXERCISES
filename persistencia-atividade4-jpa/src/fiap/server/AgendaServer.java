package fiap.server;

import java.util.List;

import fiap.dao.impl.AgendaDao;
import fiap.entity.Agenda;

public class AgendaServer {

	static AgendaDao agendaDao;

	public AgendaServer() {
		super();
		agendaDao = new AgendaDao(Agenda.class);
	}

	public void adicionar(StringBuilder log, Agenda agenda) {
		agendaDao.adicionar(agenda);
		log.append("Agenda salvo." + "\n");
	}

	public List<Agenda> listar(StringBuilder log) {
		log.append("\n >>> Lista de Agendas <<< \n");
		List<Agenda> agendas = agendaDao.listar();
		for (Agenda agenda : agendas) {
			log.append("--- Agenda: " + agenda.toString() + "\n");
		}
		return agendas;
	}

	public Agenda buscar(StringBuilder log, int id) {
		log.append("\n >>> Busca Agenda <<< \n");
		try {
			Agenda agenda = agendaDao.buscar(id);
			log.append("--- Agenda: " + agenda.toString() + "\n");
			return agenda;
		} catch (Exception e) {
			log.append("--- Agenda nao foi encontrado.\n");
			return null;
		}
	}

	public void alterar(StringBuilder log, Agenda agenda) {
		log.append("\n >>> Altera Agenda <<< \n");
		agendaDao.atualizar(agenda);
		log.append("--- Agenda Atualizado.\n");
	}

	public void remover(StringBuilder log, Agenda agenda) {
		log.append("\n >>> Remove Agenda <<< \n");
		agendaDao.remover(agenda);
		log.append("--- Agenda Removido.\n");
	}

}
