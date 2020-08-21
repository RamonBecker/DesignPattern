package br.edu.pattertproject.fireman.part3.facade.model;

import java.util.Map;

public interface IDao {
	
	public void add(Map<Object,  Object> lista, Object object) throws Exception;
	

	public void buscar();

	public void listar();
}
