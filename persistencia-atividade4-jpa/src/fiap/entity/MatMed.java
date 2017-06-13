package fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matmed", schema = "hospital")
public class MatMed implements Serializable {

	private static final long serialVersionUID = 7522553007338846186L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Paciente paciente;

	@Column(name = "DESCRICAO", length = 45)
	private String descricao;

	@Column(name = "FABRICANTE", length = 45)
	private String fabricante;

	@Column(name = "VALOR")
	private Double preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "MatMed [id=" + id + ", descricao=" + descricao + ", fabricante=" + fabricante + ", preco=" + preco
				+ "]";
	}
	
}
