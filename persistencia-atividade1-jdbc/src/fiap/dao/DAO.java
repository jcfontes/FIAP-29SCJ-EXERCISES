package fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	protected static Connection con;
	protected static ResultSet rs;
	protected static PreparedStatement ps;

	private static String url = "jdbc:mysql://localhost:3306/vendas";

	protected static void abrirConexao() throws SQLException{
		con = DriverManager.getConnection(url, "root", "root");
	}
	
	protected static void fecharConexao() throws SQLException{
		con.close();
		if (rs != null) rs.close();
		if (ps != null) ps.close();
	}
}
