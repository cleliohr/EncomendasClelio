package br.com.fatec.encomendas.api.entity;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class Ocorrencia {

	public static final String TABLE = "OCORRENCIA";
	public static final String COL_ID = "ID";
	public static final String COL_ENCOMENDA_ID = "ENCOMENDA_ID";
	public static final String COL_VIAGEM_ID = "VIAGEM_ID";
	public static final String COL_DESCRICAO = "DESCRICAO";
	public static final String COL_DATA_HORA = "DATA_HORA";
	public static final String COL_TIPO_OCORRENCIA = "TIPO_OCORRENCIA";

	private Long id;
	private Encomenda encomenda;
	private Viagem viagem;
	private String descricao;
	private Date dataHora;
	private String tipoOcorrencia;

	public Ocorrencia() {
	}

	public Ocorrencia(Long id, Encomenda encomenda, Viagem viagem, String descricao, Date dataHora,
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

	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_ENCOMENDA_ID, COL_VIAGEM_ID, COL_DESCRICAO, COL_DATA_HORA,
				COL_TIPO_OCORRENCIA);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_ENCOMENDA_ID, COL_VIAGEM_ID, COL_DESCRICAO, COL_DATA_HORA,
				COL_TIPO_OCORRENCIA };
	}

}
