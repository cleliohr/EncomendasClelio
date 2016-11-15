package br.com.fatec.encomendas.api.dto;

import java.util.Date;

import br.com.fatec.encomendas.api.entity.Encomenda;
import br.com.fatec.encomendas.api.entity.Viagem;

public class OcorrenciaDTO {

	private Long id;
	private Encomenda encomenda;
	private Viagem viagem;
	private String descricao;
	private Date dataHora;
	private String tipoOcorrencia;
	
	public OcorrenciaDTO() {		
	}
	
	public OcorrenciaDTO(Long id, Encomenda encomenda, Viagem viagem, String descricao, Date dataHora,
			String tipoOcorrencia) {
		this.id = id;
		this.encomenda = encomenda;
		this.viagem = viagem;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Encomenda getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(String tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}
	
	@Override
	public String toString() {
		return "Ocorrencia[" + this.id + " - " + this.descricao + "]";
	
	}
}