package br.com.fatec.encomendas.api.dto;

import br.com.fatec.encomendas.api.entity.Zona;

public class VeiculoDTO {
	private Long id;
	private String nome;
	private Zona zona;
	
	public VeiculoDTO() {
	}
	
	public VeiculoDTO(Long id, String nome, Zona zona) {
		this.id = id;
		this.nome = nome;
		this.zona = zona;
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

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	@Override
	public String toString() {
		return "Veiculo[" + this.id + " - " + this.nome + "]";
	}
}