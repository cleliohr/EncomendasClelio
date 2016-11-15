package br.com.fatec.encomendas.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.encomendas.api.dto.EnderecoDTO;
import br.com.fatec.encomendas.api.dto.UsuarioDTO;

public class ContextoUsuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7979991627914641337L;

	private UsuarioDTO usuario;
	private List<UsuarioDTO> usuarios;
	private List<EnderecoDTO> enderecos;
	
	public List<UsuarioDTO> getUsuarios() {
		return this.usuarios;
	}
	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	public UsuarioDTO getUsuario() {
		return this.usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public List<EnderecoDTO> getEnderecos() {
		return this.enderecos;
	}
	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}
	
	
	
	

}
