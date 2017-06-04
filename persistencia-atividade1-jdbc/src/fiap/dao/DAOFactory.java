package fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fiap.dao.impl.MySQLFactoryDAO;
import fiap.dao.impl.mysql.MySQLClienteDAO;
import fiap.dao.impl.mysql.MySQLPedidoDAO;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	protected static Connection con;
	protected static ResultSet rs;
	protected static PreparedStatement ps;

	public abstract MySQLClienteDAO getClienteDAO();

	public abstract MySQLPedidoDAO getPedidoDAO();

	public static DAOFactory getDaoFactory(int tipo) {
		switch (tipo) {
		case MYSQL:
			return new MySQLFactoryDAO();
		default:
			return null;
		}
	}

	protected static void fecharConexao() throws SQLException {
		if (con != null)
			con.close();
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
	}
}
