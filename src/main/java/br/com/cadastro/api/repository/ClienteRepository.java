package br.com.cadastro.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cadastro.api.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
