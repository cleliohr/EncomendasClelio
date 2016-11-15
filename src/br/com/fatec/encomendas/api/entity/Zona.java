package br.com.fatec.encomendas.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class Zona {

	public static final String TABLE = "ZONA";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	
	private Long id;
	private String nome;
	
	public Zona() {
	}
	
	public Zona(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_NOME);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NOME};
	}
}
