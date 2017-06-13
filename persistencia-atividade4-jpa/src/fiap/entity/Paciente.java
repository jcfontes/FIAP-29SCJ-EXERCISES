package fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "paciente", schema = "hospital")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 6935747933591973725L;

	@Id
	@Column(name = "CPF")
	private String cpf;

	@Column(name = "NOME", length = 45)
	private String nome;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "DATANASC")
	private Date data;

	@Column(name = "TELEFONE", length = 20)
	private String telefone;

	@ManyToMany
	@JoinTable(name = "agenda_paciente", 
	joinColumns = @JoinColumn(name = "CPF"), 
	inverseJoinColumns = @JoinColumn(name = "ID"))
	private List<Agenda> horarios;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paciente")
	private List<Procedimento> procedimentos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paciente")
	private List<MatMed> materiais;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Agenda> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Agenda> horarios) {
		this.horarios = horarios;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public List<MatMed> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<MatMed> materiais) {
		this.materiais = materiais;
	}

	@Override
	public String toString() {
		return "Paciente [cpf=" + cpf + ", nome=" + nome + ", data=" + data + ", telefone=" + telefone + ", horarios="
				+ horarios + ", procedimentos=" + procedimentos + ", materiais=" + materiais + "]";
	}

}
