package br.com.fatec.encomendas.api.dto;

import java.util.Date;

import br.com.fatec.encomendas.api.entity.Veiculo;

public class ViagemDTO {

	private Long id;
	private Veiculo veiculo;
	private Date data;

	public ViagemDTO() {
	}

	public ViagemDTO(Long id, Veiculo veiculo, Date data) {
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

	@Override
	public String toString() {
		return "Viagem[" + this.id + "]";
	}
}