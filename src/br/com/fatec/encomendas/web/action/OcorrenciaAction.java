package br.com.fatec.encomendas.web.action;

import br.com.fatec.encomendas.api.service.OcorrenciaService;
import br.com.fatec.encomendas.web.context.ContextoOcorrencia;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class OcorrenciaAction extends ProjetoAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -915497495404544490L;

	private static final String SUCESSO = "ok";

	private OcorrenciaService service;
	private ContextoOcorrencia contexto = new ContextoOcorrencia();

	public OcorrenciaAction() {
		this.service = ImplFinder.getImpl(OcorrenciaService.class);
	}

	public String findAll() {
		contexto.setOcorrencias(service.listar());
		return SUCESSO;
	}

	public String gravar() {
		if (this.contexto.getOcorrencia().getId() != null) {
			this.service.atualizar(this.contexto.getOcorrencia());
		} else {
			this.service.salvar(this.contexto.getOcorrencia());
		}
		return this.find();
	}

	public String find() {
		contexto.setOcorrencias(service.listarPorEncomenda(this.contexto.getOcorrencia().getEncomenda().getId()));
		return SUCESSO;
	}

	public String excluir() {
		this.service.deletar(this.contexto.getOcorrencia().getId());
		return SUCESSO;
	}

	public ContextoOcorrencia getContexto() {
		return this.contexto;
	}

	public void setContexto(ContextoOcorrencia contexto) {
		this.contexto = contexto;
	}
}
