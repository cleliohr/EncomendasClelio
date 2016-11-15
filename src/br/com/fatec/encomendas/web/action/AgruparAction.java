package br.com.fatec.encomendas.web.action;

import br.com.fatec.encomendas.api.service.AgrupamentoService;
import br.com.fatec.encomendas.web.context.ContextoAgrupar;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class AgruparAction extends ProjetoAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8242717407553870397L;

	private static final String SUCESSO = "ok";

	private AgrupamentoService service;
	private ContextoAgrupar contexto = new ContextoAgrupar();

	public AgruparAction() {
		this.service = ImplFinder.getImpl(AgrupamentoService.class);
	}

	public String agrupar() {
		if (service.agrupar())
			contexto.setMensagem("Encomendas agrupadas com sucesso");
		else
			contexto.setMensagem("Ocorreu um erro ou não existem ocorrências para serem agrupadas");
		return findAll();
	}

	public String findAll() {
		contexto.setViewsAgrupar(service.listar());
		return SUCESSO;
	}

	public ContextoAgrupar getContexto() {
		return contexto;
	}

	public void setContexto(ContextoAgrupar contexto) {
		this.contexto = contexto;
	}

}
