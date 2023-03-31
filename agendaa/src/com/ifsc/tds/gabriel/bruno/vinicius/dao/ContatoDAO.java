package com.ifsc.tds.gabriel.bruno.vinicius.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ifsc.tds.gabriel.bruno.vinicius.entity.Contato;


public class ContatoDAO implements DAO<Contato> {

	@Override
	public Contato get(Long id) {
		Contato contato = null;
		String sql = "select * from contato where id = ?";
		
		//rec conexao bd
		Connection conexao = null;
		
		//preparação consulta
		PreparedStatement stm = null;
		
		//classe para guardar retorno operação
		ResultSet rset = null;
		
		try {
			
			conexao = new Conexao().getConnection();
			
			//preparar consulta do bd
			stm = conexao.prepareStatement(sql);
			stm.setInt(1, id.intValue());
			rset = stm.executeQuery();
			
			while(rset.next()) {
			 contato = new Contato();
			
				contato.setId(rset.getLong("id"));
				contato.setNome(rset.getString("nome"));
				contato.setTelefone(rset.getString("telefone"));
				contato.setEmail(rset.getString("email"));
			
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stm != null) {
					stm.close();
				}
				
				if(conexao != null) {
					conexao.close();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return contato;
	}

	@Override
	public List<Contato> getAll() {
		List<Contato> contatos = new ArrayList<Contato>();
		
		String sql = "select * from contato";
		
		//recuperar conexao bd
		Connection conexao = null;
		
		//preparação consulta
		PreparedStatement stm = null;
		
		//classe para guardar retorno operação
		ResultSet rset = null;
		
		try {
			
			conexao = new Conexao().getConnection();
			
			//preparar consulta do bd
			stm = conexao.prepareStatement(sql);
			rset = stm.executeQuery();
			
			while(rset.next()) {
			 Contato contato = new Contato();
			//atribui  de campos para atributo
				contato.setId(rset.getLong("id"));
				contato.setNome(rset.getString("nome"));
				contato.setTelefone(rset.getString("telefone"));
				contato.setEmail(rset.getString("email"));
				
				contatos.add(contato);
			
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stm != null) {
					stm.close();
				}
				
				if(conexao != null) {
					conexao.close();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return contatos;
	}

	@Override
	public int save(Contato contato) {
		
		String sql = "insert into contato (nome, telefone, email)" + " values (?, ?, ?)";
		
		//recuperar conexao bd
		Connection conexao = null;
		
		//preparação consulta
		PreparedStatement stm = null;
		
		try {
			
			conexao = new Conexao().getConnection();
			
			//preparar consulta do bd
			stm = conexao.prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getTelefone());
			stm.setString(3, contato.getEmail());
			
			stm.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stm != null) {
					stm.close();
				}
				
				if(conexao != null) {
					conexao.close();
				}
				return 1;
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return 0;
	}

	@Override
	public boolean delete(Contato contato, String[] params) {
		String sql = "delete from contato where id = ?";
		
		//recuperar4 conexao bd
		Connection conexao = null;
		
		//preparação consulta
		PreparedStatement stm = null;
		
		try {
			
			conexao = new Conexao().getConnection();
			
			//preparar consulta do bd
			stm = conexao.prepareStatement(sql);
			stm.setLong(1, contato.getId());
			stm.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stm != null) {
					stm.close();
				}
				
				if(conexao != null) {
					conexao.close();
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		
		return false;
	}

	@Override
	public boolean update(Contato contato, String[] params) {
String sql = "update contato set nome = ?, telefone = ?, email = ? where id = ?";
		
		//rec conexao bd
		Connection conexao = null;
		
		//preparação consulta
		PreparedStatement stm = null;
		
		try {
			
			conexao = new Conexao().getConnection();
			
			//preparar consulta do bd
			stm = conexao.prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getTelefone());
			stm.setString(3, contato.getEmail());
			stm.setLong(4, contato.getId());
			
			stm.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stm != null) {
					stm.close();
				}
				
				if(conexao != null) {
					conexao.close();
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		
		return false;
	}

}
