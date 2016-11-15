package br.com.fatec.encomendas.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class ViewAgrupar {
	public static final String TABLE = "V_AGRUPAR";
	public static final String COL_ENCOMENDA_DESCRICAO = "ENCOMENDA_DESCRICAO";
	public static final String COL_USUARIO_NOME = "USUARIO_NOME";
	public static final String COL_VEICULO_NOME = "VEICULO_NOME";
	public static final String COL_STATUS = "STATUS";

	private String encomendaDescricao;
	private String usuarioNome;
	private String veiculoNome;
	private String status;

	public ViewAgrupar() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ViewAgrupar(String encomendaDescricao, String usuarioNome, String veiculoNome, String status) {
		super();
		this.encomendaDescricao = encomendaDescricao;
		this.usuarioNome = usuarioNome;
		this.veiculoNome = veiculoNome;
		this.status = status;
	}

	public String getEncomendaDescricao() {
		return encomendaDescricao;
	}

	public void setEncomendaDescricao(String encomendaDescricao) {
		this.encomendaDescricao = encomendaDescricao;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}

	public String getVeiculoNome() {
		return veiculoNome;
	}

	public void setVeiculoNome(String veiculoNome) {
		this.veiculoNome = veiculoNome;
	}

	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ENCOMENDA_DESCRICAO, COL_USUARIO_NOME, COL_VEICULO_NOME);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ENCOMENDA_DESCRICAO, COL_USUARIO_NOME, COL_VEICULO_NOME };
	}
}
