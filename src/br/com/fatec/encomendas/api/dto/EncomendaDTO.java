package br.com.fatec.encomendas.api.dto;

import br.com.fatec.encomendas.api.entity.Usuario;

public class EncomendaDTO{
	// atributos
	private Long id;
	private Usuario usuario;
	private String status;
	private String descricao;
	
	public EncomendaDTO() {
		
	}
	
	public EncomendaDTO(Long id, Usuario usuario, String status, String descricao){
		this.id = id;
		this.usuario = usuario;
		this.status = status;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id = id;
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	public void setUsuario (Usuario usuario){
		this.usuario = usuario;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setStatus (String status){
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Encomenda["+ this.id +"]";
	}
}