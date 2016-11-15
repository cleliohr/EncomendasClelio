package br.com.fatec.encomendas.api.dto;

public class AgruparDTO {
	// atributos
	private String encomendaDescricao;
	private String usuarioNome;
	private String veiculoNome;
	private String status;

	public AgruparDTO() {

	}

	public AgruparDTO(String encomendaDescricao, String usuarioNome, String veiculoNome, String status) {
		super();
		this.encomendaDescricao = encomendaDescricao;
		this.usuarioNome = usuarioNome;
		this.veiculoNome = veiculoNome;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	@Override
	public String toString() {
		return "AgruparDTO [encomendaDescricao=" + encomendaDescricao + ", usuarioNome=" + usuarioNome
				+ ", veiculoNome=" + veiculoNome + "]";
	}

}
