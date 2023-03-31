package com.ifsc.tds.gabriel.bruno.vinicius.dao;

import java.util.List;

public interface DAO<Contato> {
	
	Object get(Long id);
	List<Contato> getAll();
	
	int save(Contato t);
	
	boolean update(Contato t, String[] params);
	
	boolean delete(Contato t, String[] params);

}
