package fiap.dao;

import java.sql.Date;
import java.sql.SQLException;

import fiap.entity.Pedido;

public class PedidoDAO extends DAO {

	public Pedido incluirPedido(Pedido pedido) throws SQLException {
		abrirConexao();

		String sql = "INSERT INTO PEDIDO(ID_CLIENTE, DATA, DESCRICAO, VALOR) VALUES(?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setInt(1, pedido.getIdCliente());
		ps.setDate(2, new Date(pedido.getData().getTime()));
		ps.setString(3, pedido.getDescricao());
		ps.setDouble(4, pedido.getValor());
		ps.execute();

		sql = "SELECT LAST_INSERT_ID() AS ID";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		if (rs.next()) {
			pedido.setId(rs.getInt("ID"));
		}

		fecharConexao();

		return pedido;
	}

	public Pedido buscarPedido(int id) throws SQLException {
		Pedido pedido = null;

		abrirConexao();

		String sql = "SELECT ID, ID_CLIENTE, DATA, DESCRICAO, VALOR FROM PEDIDO WHERE ID = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();

		if (rs.first()) {
			pedido = new Pedido(id, rs.getInt("ID_CLIENTE"), rs.getDate("DATA"), rs.getString("DESCRICAO"),
					rs.getDouble("VALOR"));
		}

		fecharConexao();

		return pedido;
	}

}
