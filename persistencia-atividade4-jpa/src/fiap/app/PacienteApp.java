package fiap.app;

import java.util.List;

import fiap.entity.Agenda;
import fiap.entity.MatMed;
import fiap.entity.Paciente;
import fiap.entity.Procedimento;
import fiap.factory.AgendaFactory;
import fiap.factory.PacienteFactory;
import fiap.server.AgendaServer;
import fiap.server.PacienteServer;

public class PacienteApp {

	public static void main(String[] args) {

		PacienteServer pacienteServer = new PacienteServer();
		AgendaServer agendaServer = new AgendaServer();
		StringBuilder log = new StringBuilder();

		// ADICIONAR PACIENTE
		log.append("\n >>> Massa Horarios <<< \n");
		List<Agenda> horarios = AgendaFactory.criarHorarios(null, 3);
		for (Agenda horario : horarios) {
			agendaServer.adicionar(log, horario);
		}
		List<Agenda> horariosBase = agendaServer.listar(log);
		
		log.append("\n >>> Cria Paciente <<< \n");
		Paciente paciente = PacienteFactory.criarPaciente(horariosBase);
		pacienteServer.adicionar(log, paciente);

		// LISTAR PACIENTE
		List<Paciente> pacientes = pacienteServer.listar(log);

		// JPQL - BUSCAR PACIENTE
		String cpf = pacientes.get(0).getCpf();
		Paciente pacienteBase = pacienteServer.buscar(log, cpf);

		// JPQL - BUSCAR PACIENTE PROCEDIMENTOS 
		List<Procedimento> procedimentos = pacienteServer.buscarProcedimentos(log, cpf);
		
		// JPQL - BUSCAR PACIENTE MATERIAIS 
		List<MatMed> materiais = pacienteServer.buscarMateriais(log, cpf);
		
		// ALTERAR PACIENTE
		pacienteBase.setNome("Paciente Alterado");
		pacienteServer.alterar(log, pacienteBase);
		Paciente pacienteAlterado = pacienteServer.buscar(log, pacienteBase.getCpf());

		// REMOVER PACIENTE
		pacienteServer.remover(log, pacienteAlterado);
		pacienteServer.buscar(log, pacienteAlterado.getCpf());
		System.out.println(log.toString());
	}

}
