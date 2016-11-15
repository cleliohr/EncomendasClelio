package br.com.fatec.encomendas.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.encomendas.api.dto.VeiculoDTO;
import br.com.fatec.encomendas.api.dto.ViagemDTO			;


public class ContextoViagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3437974971148615730L;

	
	private ViagemDTO viagem;
	
	private List<ViagemDTO> viagens;
	private List<VeiculoDTO> veiculos;
	
	public ViagemDTO getViagem() {
		return this.viagem;
	}
	public void setViagem(ViagemDTO viagem) {
		this.viagem = viagem;
	}
	public List<ViagemDTO> getViagens() {
		return this.viagens;
	}
	public void setViagens(List<ViagemDTO> viagens) {
		this.viagens = viagens;
	}
	public List<VeiculoDTO> getVeiculos() {
		return this.veiculos;
	}
	public void setVeiculos(List<VeiculoDTO> veiculos) {
		this.veiculos = veiculos;
	}
	
	
}
