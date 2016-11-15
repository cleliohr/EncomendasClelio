package br.com.fatec.encomendas.api.dto;

import br.com.fatec.encomendas.api.entity.Zona;

public class EnderecoDTO {
	
	//Atributos
	
	private Long id;
	private String cep;
	private CidadeDTO cidadeDTO;
	private String logradouro;
	private String bairro;
	private Zona zona;
	
	public EnderecoDTO() {
		
	}
	
	public EnderecoDTO(Long id, String cep, CidadeDTO cidadeDTO, String logradouro, String bairro, Zona zona) {
		this.id = id;
		this.cep = cep;
		this.cidadeDTO = cidadeDTO;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.zona = zona;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public CidadeDTO getCidade() {
		return cidadeDTO;
	}
	
	public void setCidade(CidadeDTO cidadeDTO) {
		this.cidadeDTO = cidadeDTO;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public Zona getZona() {
		return zona;
	}
	
	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	@Override
	public String toString() {
		return "Endereco[" + this.id + " - " + this.logradouro + "]";
	}
	
}