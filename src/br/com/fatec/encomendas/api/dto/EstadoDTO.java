package br.com.fatec.encomendas.api.dto;

public class EstadoDTO {
	private String nome;
	private String valor;
	
	public EstadoDTO() {
		
	}
	
	public EstadoDTO(String nome, String valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
