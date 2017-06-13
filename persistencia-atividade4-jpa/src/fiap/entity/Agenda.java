package fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "agenda", schema = "hospital")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 4098459743119984437L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "DATA")
	private Date data;

	@Temporal(value = TemporalType.TIME)
	@Column(name = "HORA")
	private Date hora;

	@Column(name = "DESCRICAO", length = 45)
	private String descricao;
	
	@ManyToMany(mappedBy="horarios")
	private List<Paciente> pacientes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", data=" + data + ", hora=" + hora + ", descricao=" + descricao + "]";
	}

}
