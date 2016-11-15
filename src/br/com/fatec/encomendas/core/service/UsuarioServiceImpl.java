package br.com.fatec.encomendas.core.service;

import java.util.List;

import br.com.fatec.encomendas.api.dao.UsuarioDAO;
import br.com.fatec.encomendas.api.dto.UsuarioDTO;
import br.com.fatec.encomendas.api.entity.Usuario;
import br.com.fatec.encomendas.api.service.UsuarioService;
import br.com.fatec.encomendas.core.converter.UsuarioDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDAO usuarioDAO;
	private UsuarioDTOConverter usuarioDTOConverter;

	public UsuarioServiceImpl() {
		this.usuarioDAO = ImplFinder.getImpl(UsuarioDAO.class);
		this.usuarioDTOConverter = ImplFinder.getFinalImpl(UsuarioDTOConverter.class);
	}

	@Override
	public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
		Usuario usuarioEntidade = this.usuarioDTOConverter.toEntity(usuarioDTO);
		Long id = this.usuarioDAO.save(usuarioEntidade);
		usuarioDTO.setId(id);
		return usuarioDTO;
	}

	@Override
	public void atualizar(UsuarioDTO usuarioDTO) {
		Usuario usuarioEntidade = this.usuarioDTOConverter.toEntity(usuarioDTO);
		this.usuarioDAO.update(usuarioEntidade);
	}

	@Override
	public void deletar(Long Id) {
		this.usuarioDAO.delete(Id);
	}

	@Override
	public List<UsuarioDTO> listar() {
		return this.usuarioDTOConverter.toDTO(this.usuarioDAO.findAll());
	}

	@Override
	public UsuarioDTO buscarPorId(Long Id) {
		return this.usuarioDTOConverter.toDTO(this.usuarioDAO.findById(Id));
	}

}
