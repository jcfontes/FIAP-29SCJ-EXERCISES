package fiap.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

import fiap.dao.DAOFactory;
import fiap.dao.impl.mysql.MySQLClienteDAO;
import fiap.dao.impl.mysql.MySQLPedidoDAO;

public class MySQLFactoryDAO extends DAOFactory {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/vendas";

	public static Connection criarConexao() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, "root", "root");
	}

	@Override
	public MySQLClienteDAO getClienteDAO() {
		return new MySQLClienteDAO();
	}

	@Override
	public MySQLPedidoDAO getPedidoDAO() {
		return new MySQLPedidoDAO();
	}

}
