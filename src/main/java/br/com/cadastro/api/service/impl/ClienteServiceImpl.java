package br.com.cadastro.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.api.model.Cliente;
import br.com.cadastro.api.repository.ClienteRepository;
import br.com.cadastro.api.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienterepository;
	
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return this.clienterepository.findAll();
	}

	@Override
	public Cliente findbyId(String id) {
		// TODO Auto-generated method stub
		return this.clienterepository.findOne(id);
	}

	@Override
	public Cliente insert(Cliente cliente) {
		// TODO Auto-generated method stub
		return this.clienterepository.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente) {
		// TODO Auto-generated method stub
		return this.clienterepository.save(cliente);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		this.clienterepository.delete(id);
	}
	
	
	
}