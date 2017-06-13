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
@Table(name = "procedimento", schema = "hospital")
public class Procedimento implements Serializable {

	private static final long serialVersionUID = 145873159444410811L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Paciente paciente;

	@Column(name = "DESCRICAO", length = 45)
	private String descricao;

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Procedimento [id=" + id + ", descricao=" + descricao + ", preco=" + preco + "]";
	}

}
