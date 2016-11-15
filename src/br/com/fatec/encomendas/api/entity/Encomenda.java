package br.com.fatec.encomendas.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class Encomenda {

	public static final String TABLE = "ENCOMENDA";
	public static final String COL_ID = "ID";
	public static final String COL_USUARIO_ID = "USUARIO_ID";
	public static final String COL_STATUS = "STATUS";
	public static final String COL_DESCRICAO = "DESCRICAO";

	private Long id;
	private Usuario usuario;
	private String status;
	private String descricao;

	public Encomenda() {
	}

	public Encomenda(Long id, Usuario usuario, String status, String descricao) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_USUARIO_ID, COL_STATUS, COL_DESCRICAO);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_USUARIO_ID, COL_STATUS, COL_DESCRICAO };
	}

}
