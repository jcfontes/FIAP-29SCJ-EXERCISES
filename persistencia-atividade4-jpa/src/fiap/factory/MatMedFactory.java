package fiap.factory;

import java.util.ArrayList;
import java.util.List;

import fiap.entity.Paciente;
import fiap.entity.MatMed;

public class MatMedFactory {

	public static List<MatMed> criarMateriais(Paciente paciente, int qtdMateriais) {

		List<MatMed> materiais = new ArrayList<>();
		for (int i = 0; i < qtdMateriais; i++) {
			MatMed matMed = criarMaterial(paciente);
			materiais.add(matMed);
		}
		return materiais;
	}

	public static MatMed criarMaterial(Paciente paciente) {
		MatMed material = new MatMed();
		material.setDescricao("MatMed: " + Math.floor(Math.random() * 100));
		material.setPreco(Math.floor(Math.random() * 100));
		if (paciente != null) {
			material.setPaciente(paciente);
		}
		return material;
	}

}
