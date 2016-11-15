package br.com.fatec.encomendas.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.encomendas.api.dto.EncomendaDTO;
import br.com.fatec.encomendas.api.dto.OcorrenciaDTO;
import br.com.fatec.encomendas.api.dto.ViagemDTO;

public class ContextoOcorrencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3802612160162970151L;

	private OcorrenciaDTO ocorrencia;
	private List<OcorrenciaDTO> ocorrencias;
	private List<EncomendaDTO> encomendas;
	private List<ViagemDTO> viagens;
	
	
	public OcorrenciaDTO getOcorrencia() {
		return this.ocorrencia;
	}
	public void setOcorrencia(OcorrenciaDTO ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	public List<OcorrenciaDTO> getOcorrencias() {
		return this.ocorrencias;
	}
	public void setOcorrencias(List<OcorrenciaDTO> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	public List<EncomendaDTO> getEncomendas() {
		return this.encomendas;
	}
	public void setEncomendas(List<EncomendaDTO> encomendas) {
		this.encomendas = encomendas;
	}
	public List<ViagemDTO> getViagens() {
		return this.viagens;
	}
	public void setViagens(List<ViagemDTO> viagens) {
		this.viagens = viagens;
	}
	
	
	
	
	
	
}
