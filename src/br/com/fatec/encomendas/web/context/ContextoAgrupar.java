package br.com.fatec.encomendas.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.encomendas.api.dto.AgruparDTO;

public class ContextoAgrupar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1059021137822126821L;

	private AgruparDTO viewAgrupar;
	private List<AgruparDTO> viewsAgrupar;
	private String mensagem;

	public AgruparDTO getViewAgrupar() {
		return viewAgrupar;
	}

	public void setViewAgrupar(AgruparDTO viewAgrupar) {
		this.viewAgrupar = viewAgrupar;
	}

	public List<AgruparDTO> getViewsAgrupar() {
		return viewsAgrupar;
	}

	public void setViewsAgrupar(List<AgruparDTO> viewsAgrupar) {
		this.viewsAgrupar = viewsAgrupar;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
