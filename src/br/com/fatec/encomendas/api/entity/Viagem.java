package br.com.fatec.encomendas.api.entity;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class Viagem {

	public static final String TABLE = "VIAGEM";
	public static final String COL_ID = "ID";
	public static final String COL_VEICULO_ID = "VEICULO_ID";
	public static final String COL_DATA = "DATA";

	private Long id;
	private Veiculo veiculo;
	private Date data;

	public Viagem() {
	}

	public Viagem(Long id, Veiculo veiculo, Date data) {
		this.id = id;
		this.veiculo = veiculo;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_VEICULO_ID, COL_DATA);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_VEICULO_ID, COL_DATA };
	}
}
