package com.ifsc.tds.gabriel.bruno.vinicius.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String Login_Banco = "root";

	private static final String Senha_Banco = "";

	private static final String Url_Banco = "jdbc:mysql://localhost:3306/agenda?autoReconnect=true&useSSL=false";

	public Connection getConnection() {
		Connection conexao = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(Conexao.Url_Banco, Conexao.Login_Banco, Conexao.Senha_Banco);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao Banco de Dados. Erro: " + e);
		} catch(ClassNotFoundException e) {
			System.out.println("Não foi possivel carregar a clase JDBC MySQL. Erro: " + e);
		} catch(Exception e) {
			System.out.println("Erro Geral. Erro: " + e);
			
		}
	
	return conexao;

	}
}
