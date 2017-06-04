package fiap.entity;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 6352010981250950639L;
	private int id;
	private int idCliente;
	private Date data;
	private String descricao;
	private Double valor;

	public Pedido(int id, int idCliente, Date data, String descricao, Double valor) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Pedido(int idCliente, Date data, String descricao, Double valor) {
		super();
		this.idCliente = idCliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
