package br.com.fatec.encomendas.web.action;

import br.com.fatec.encomendas.api.service.VeiculoService;
import br.com.fatec.encomendas.web.context.ContextoVeiculo;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class VeiculoAction extends ProjetoAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5037853764264391252L;

	private static final String SUCESSO = "ok";

	private VeiculoService service;
	private ContextoVeiculo contexto = new ContextoVeiculo();

	public VeiculoAction() {
		this.service = ImplFinder.getImpl(VeiculoService.class);
	}

	public String findAll() {
		contexto.setVeiculos(service.listar());
		return SUCESSO;
	}

	public String gravar() {
		if (this.contexto.getVeiculo().getId() != null) {
			this.service.atualizar(this.contexto.getVeiculo());
		} else {
			this.service.salvar(this.contexto.getVeiculo());
		}
		return this.findAll();
	}

	public String excluir() {
		this.service.deletar(this.contexto.getVeiculo().getId());
		return this.findAll();
	}

	public ContextoVeiculo getContexto() {
		return this.contexto;
	}

	public void setContexto(ContextoVeiculo contexto) {
		this.contexto = contexto;
	}
}
