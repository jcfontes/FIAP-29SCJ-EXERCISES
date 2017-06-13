package fiap.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fiap.entity.Agenda;
import fiap.entity.Paciente;

public class PacienteFactory {

	public static List<Paciente> criarPacientes(List<Agenda> horarios, int qtdPacientes) {

		List<Paciente> pacientes = new ArrayList<>();

		for (int i = 0; i < qtdPacientes; i++) {
			Paciente paciente = criarPaciente(horarios);
			pacientes.add(paciente);
		}
		return pacientes;
	}

	public static Paciente criarPaciente(List<Agenda> horarios) {
		Paciente paciente = new Paciente();
		paciente.setCpf((int) Math.floor(Math.random() * 100000000)+"");
		
		paciente.setData(new Date());
		paciente.setNome("Nome: "+Math.floor(Math.random() * 100));
		paciente.setTelefone((int) Math.floor(Math.random() * 1000)+"");
		paciente.setProcedimentos(ProcedimentoFactory.criarProcedimentos(paciente, 2));
		paciente.setMateriais(MatMedFactory.criarMateriais(paciente, 3));
		
		if (horarios != null) {
			List<Paciente> pacientes = new ArrayList<>(); 
			pacientes.add(paciente);
			
			for (Agenda horario : horarios) {
				horario.setPacientes(pacientes);
			}
			paciente.setHorarios(horarios);
		}
		return paciente;
	}

}
