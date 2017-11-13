package br.com.cadastro.api.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;

public class Cliente {

	@Id
	private String id;
	
	
	private String nome;
	private String sobrenome;
	
	@NotEmpty(message = "E-mail Nome não pode ser vazio")
	@Email(message = "E-mail invalido")
	private String email;
	
	@NotEmpty(message = "CPF não pode ser vazio")
	@CPF(message = "Cpf invalido")
	private String cpf;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
