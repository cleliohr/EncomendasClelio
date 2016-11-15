package br.com.fatec.encomendas.api.dto;

public class ZonaDTO {

	private Long id;
	private String nome;

	public ZonaDTO() {
	}

	public ZonaDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Zona[" + this.id + " - " + this.nome + "]";
	}

}