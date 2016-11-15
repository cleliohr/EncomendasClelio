package br.com.fatec.encomendas.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.encomendas.api.dto.VeiculoDTO;
import br.com.fatec.encomendas.api.dto.ZonaDTO;


public class ContextoVeiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2166078636193507144L;

	private VeiculoDTO veiculo;
	
	private List<VeiculoDTO> veiculos;
	private List<ZonaDTO> zonas;
	
	
	public VeiculoDTO getVeiculo() {
		return this.veiculo;
	}
	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}
	public List<VeiculoDTO> getVeiculos() {
		return this.veiculos;
	}
	public void setVeiculos(List<VeiculoDTO> veiculos) {
		this.veiculos = veiculos;
	}
	public List<ZonaDTO> getZonas() {
		return this.zonas;
	}
	public void setZonas(List<ZonaDTO> zonas) {
		this.zonas = zonas;
	}
	
	
}
