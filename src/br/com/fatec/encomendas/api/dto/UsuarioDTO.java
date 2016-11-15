package br.com.fatec.encomendas.api.dto;

import br.com.fatec.encomendas.api.entity.Endereco;

public class UsuarioDTO {
	
	private Long id;
	private String nome;
	private Endereco endereco;
	private String numero;
	private String complemento;
	private String cpf;
		
	public UsuarioDTO(Long id, String nome, Endereco endereco, String numero, String complemento, String cpf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cpf = cpf;
	}
	
	public UsuarioDTO() {
	
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Usuario[" + this.id + " - " + this.nome + "]";
	
	}
}