package br.com.fatec.encomendas.web.action;

import br.com.fatec.encomendas.api.service.UsuarioService;
import br.com.fatec.encomendas.web.context.ContextoUsuario;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class UsuarioAction extends ProjetoAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5673078408531294965L;
	private static final String SUCESSO = "ok";

	private UsuarioService service;
	private ContextoUsuario contexto = new ContextoUsuario();

	public UsuarioAction() {
		this.service = ImplFinder.getImpl(UsuarioService.class);		
	}

	public String gravar() {
		if (this.contexto.getUsuario().getId() != null) {
			this.service.atualizar(this.contexto.getUsuario());
		} else {
			this.service.salvar(this.contexto.getUsuario());
		}
		return this.findAll();
	}

	public String findAll() {
		contexto.setUsuarios(service.listar());
		return SUCESSO;
	}

	public ContextoUsuario getContexto() {
		return this.contexto;
	}

	public void setContexto(ContextoUsuario contexto) {
		this.contexto = contexto;
	}
}
