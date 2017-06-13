package fiap.factory;

import java.util.ArrayList;
import java.util.List;

import fiap.entity.Paciente;
import fiap.entity.Procedimento;

public class ProcedimentoFactory {

	public static List<Procedimento> criarProcedimentos(Paciente paciente, int qtdProcedimentos) {

		List<Procedimento> procedimentos = new ArrayList<>();
		for (int i = 0; i < qtdProcedimentos; i++) {
			Procedimento procedimento = criarProcedimento(paciente);
			procedimentos.add(procedimento);
		}
		return procedimentos;
	}

	public static Procedimento criarProcedimento(Paciente paciente) {
		Procedimento procedimento = new Procedimento();
		procedimento.setDescricao("Procedimento: " + Math.floor(Math.random() * 100));
		procedimento.setPreco(Math.floor(Math.random() * 100));
		if (paciente != null) {
			procedimento.setPaciente(paciente);
		}
		return procedimento;
	}

}
