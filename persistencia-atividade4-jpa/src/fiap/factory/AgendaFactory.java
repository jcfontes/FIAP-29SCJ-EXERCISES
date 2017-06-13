package fiap.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fiap.entity.Agenda;
import fiap.entity.Paciente;

public class AgendaFactory {

	public static List<Agenda> criarHorarios(List<Paciente> pacientes, int qtdAgendas) {

		List<Agenda> horarios = new ArrayList<>();

		for (int i = 0; i < qtdAgendas; i++) {
			Agenda horario = criarHorario(pacientes);

			horarios.add(horario);
		}
		return horarios;
	}

	public static Agenda criarHorario(List<Paciente> pacientes) {
		Agenda horario = new Agenda();
		horario.setDescricao("Agenda " + (int) Math.floor(Math.random() * 100));
		horario.setData(new Date());
		horario.setHora(new Date());

		if (pacientes != null) {
			List<Agenda> horarios = new ArrayList<>(); 
			horarios.add(horario);
			
			for (Paciente paciente : pacientes) {
				paciente.setHorarios(horarios);
			}
			horario.setPacientes(pacientes);
		}
		return horario;
	}

}
