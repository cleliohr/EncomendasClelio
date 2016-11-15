package br.com.fatec.encomendas.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.encomendas.api.dto.EnderecoDTO;
import br.com.fatec.encomendas.api.dto.ZonaDTO;

public class ContextoEndereco implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7538682327006771840L;
	
	
	private EnderecoDTO endereco;
	private List<EnderecoDTO> enderecos;
	private List<ZonaDTO> zonas;
	
	
	public EnderecoDTO getEndereco() {
		return this.endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}
	public List<ZonaDTO> getZonas() {
		return zonas;
	}
	public void setZonas(List<ZonaDTO> zonas) {
		this.zonas = zonas;
	}
	
	

}
