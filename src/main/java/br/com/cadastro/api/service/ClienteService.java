package br.com.cadastro.api.service;

import java.util.List;

import br.com.cadastro.api.model.Cliente;

public interface ClienteService {

	List<Cliente> findAll();
	
	Cliente findbyId(String id);
	
	Cliente insert (Cliente cliente);
	
	Cliente update(Cliente cliente);
	
	void delete (String id);
	
}
