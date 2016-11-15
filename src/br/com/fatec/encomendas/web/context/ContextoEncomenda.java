package br.com.fatec.encomendas.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.encomendas.api.dto.EncomendaDTO;
import br.com.fatec.encomendas.api.dto.UsuarioDTO;

public class ContextoEncomenda implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4697053213742317828L;
	
	private EncomendaDTO encomenda;
	private List<EncomendaDTO> encomendas;
	private List<UsuarioDTO> usuarios;
	
	
	public EncomendaDTO getEncomenda() {
		return this.encomenda;
	}
	public void setEncomenda(EncomendaDTO encomenda) {
		this.encomenda = encomenda;
	}
	public List<EncomendaDTO> getEncomendas() {
		return this.encomendas;
	}
	public void setEncomendas(List<EncomendaDTO> encomendas) {
		this.encomendas = encomendas;
	}
	public List<UsuarioDTO> getUsuarios() {
		return this.usuarios;
	}
	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	

}
