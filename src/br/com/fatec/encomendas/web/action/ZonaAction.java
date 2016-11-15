package br.com.fatec.encomendas.web.action;

import br.com.fatec.encomendas.api.service.ZonaService;
import br.com.fatec.encomendas.web.context.ContextoZona;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ZonaAction extends ProjetoAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 976101829812864776L;

	private static final String SUCESSO = "ok";

	private ZonaService service;
	private ContextoZona contexto = new ContextoZona();

	public ZonaAction() {
		this.service = ImplFinder.getImpl(ZonaService.class);
	}

	public String findAll() {
		contexto.setZonas(service.listar());
		return SUCESSO;
	}

	public ContextoZona getContexto() {
		return contexto;
	}

	public void setContexto(ContextoZona contexto) {
		this.contexto = contexto;
	}

}
