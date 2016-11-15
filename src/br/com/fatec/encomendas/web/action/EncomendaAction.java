package br.com.fatec.encomendas.web.action;

import br.com.fatec.encomendas.api.service.EncomendaService;
import br.com.fatec.encomendas.web.context.ContextoEncomenda;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class EncomendaAction extends ProjetoAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3703026681400437811L;

	private static final String SUCESSO = "ok";

	private EncomendaService service;
	private ContextoEncomenda contexto = new ContextoEncomenda();

	public EncomendaAction() {
		this.service = ImplFinder.getImpl(EncomendaService.class);
	}

	public String gravar() {
		if (this.contexto.getEncomenda().getId() != null) {
			this.service.atualizar(this.contexto.getEncomenda());
		} else {
			this.service.salvar(this.contexto.getEncomenda());
		}
		return this.findAll();
	}

	public String findAll() {
		this.contexto.setEncomendas(service.listar());
		return SUCESSO;
	}

	public String excluir() {
		this.service.deletar(this.contexto.getEncomenda().getId());
		return this.findAll();
	}

	public ContextoEncomenda getContexto() {
		return this.contexto;
	}

	public void setContexto(ContextoEncomenda contexto) {
		this.contexto = contexto;
	}
}
