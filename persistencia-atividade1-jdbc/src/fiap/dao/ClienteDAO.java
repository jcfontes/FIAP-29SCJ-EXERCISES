package fiap.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fiap.entity.Cliente;
import fiap.entity.Pedido;

public class ClienteDAO extends DAO {

	public Cliente incluirCliente(Cliente cliente) throws SQLException {
		abrirConexao();

		String sql = "INSERT INTO CLIENTE(NOME, EMAIL) VALUES(?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getEmail());
		ps.execute();

		sql = "SELECT LAST_INSERT_ID() AS ID";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		if (rs.next()) {
			cliente.setId(rs.getInt("ID"));
		}
		fecharConexao();
		return cliente;
	}

	public Cliente buscarCliente(int id) throws SQLException {
		Cliente cliente = null;
		List<Pedido> pedidos = new ArrayList<>();

		abrirConexao();

		String sql = "SELECT ID, DATA, DESCRICAO, VALOR FROM PEDIDO WHERE ID_CLIENTE = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();

		while (rs.next()) {
			pedidos.add(new Pedido(rs.getInt("ID"), id, rs.getDate("DATA"), rs.getString("DESCRICAO"),
					rs.getDouble("VALOR")));
		}
		rs.close();
		ps.close();

		sql = "SELECT NOME, EMAIL FROM CLIENTE WHERE ID = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();

		if (rs.first()) {
			cliente = new Cliente(id, rs.getString("NOME"), rs.getString("EMAIL"), pedidos);
		}
		rs.close();
		ps.close();

		fecharConexao();

		return cliente;
	}
}
