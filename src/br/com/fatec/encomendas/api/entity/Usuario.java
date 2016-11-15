package br.com.fatec.encomendas.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class Usuario {

	public static final String TABLE = "USUARIO";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_ENDERECO_ID = "ENDERECO_ID";
	public static final String COL_NUMERO = "NUMERO";
	public static final String COL_COMPLEMENTO = "COMPLEMENTO";
	public static final String COL_CPF = "CPF";

	private Long id;
	private String nome;
	private Endereco endereco;
	private String numero;
	private String complemento;
	private String cpf;

	public Usuario() {
	}

	public Usuario(Long id, String nome, Endereco endereco, String numero, String complemento, String cpf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cpf = cpf;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_NOME, COL_ENDERECO_ID, COL_NUMERO, COL_COMPLEMENTO, COL_CPF);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NOME, COL_ENDERECO_ID, COL_NUMERO, COL_COMPLEMENTO, COL_CPF };
	}

}
