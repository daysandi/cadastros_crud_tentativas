package br.com.cadastro.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.api.model.Cliente;
import br.com.cadastro.api.response.Response;
import br.com.cadastro.api.service.ClienteService;

@RestController
@RequestMapping(path= "/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteservice;
	
	@GetMapping()
	public ResponseEntity<Response<List<Cliente>>> findAll(){
	return ResponseEntity.ok(new Response<List<Cliente>>(this.clienteservice.findAll()));	
	}
	
	@GetMapping(path= "/{id}")
	public ResponseEntity<Response<Cliente>> findById(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(new Response<Cliente>(this.clienteservice.findbyId(id)));
		
	}
	
	@PostMapping
	public ResponseEntity<Response<Cliente>> insert(@Valid @RequestBody Cliente cliente, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro-> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Cliente>(erros));
		}
	return ResponseEntity.ok(new Response<Cliente>(this.clienteservice.insert(cliente)));	
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Response<Cliente>> update(@PathVariable(name = "id") String id, @Valid @RequestBody Cliente cliente, BindingResult result ){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Cliente>(erros));
		}
		cliente.setId(id);
		return ResponseEntity.ok(new Response<Cliente>(this.clienteservice.insert(cliente)));	
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name="id")String id){
		this.clienteservice.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
}
