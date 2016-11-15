package br.com.fatec.encomendas.core.service;

import java.util.List;

import br.com.fatec.encomendas.api.dao.EnderecoDAO;
import br.com.fatec.encomendas.api.dto.EnderecoDTO;
import br.com.fatec.encomendas.api.entity.Endereco;
import br.com.fatec.encomendas.api.service.EnderecoService;
import br.com.fatec.encomendas.core.converter.EnderecoDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class EnderecoServiceImpl implements EnderecoService {

	private EnderecoDAO enderecoDAO;
	private EnderecoDTOConverter enderecoDTOConverter;

	public EnderecoServiceImpl() {
		this.enderecoDAO = ImplFinder.getImpl(EnderecoDAO.class);
		this.enderecoDTOConverter = ImplFinder.getFinalImpl(EnderecoDTOConverter.class);
	}

	@Override
	public EnderecoDTO salvar(EnderecoDTO enderecoDTO) {
		Endereco enderecoEntidade = this.enderecoDTOConverter.toEntity(enderecoDTO);
		Long id = this.enderecoDAO.save(enderecoEntidade);
		enderecoDTO.setId(id);
		return enderecoDTO;
	}

	@Override
	public void atualizar(EnderecoDTO enderecoDTO) {
		Endereco enderecoEntidade = this.enderecoDTOConverter.toEntity(enderecoDTO);
		this.enderecoDAO.update(enderecoEntidade);
	}

	@Override
	public void deletar(Long Id) {
		this.enderecoDAO.delete(Id);
	}

	@Override
	public List<EnderecoDTO> listar() {
		return this.enderecoDTOConverter.toDTO(this.enderecoDAO.findAll());
	}

	@Override
	public EnderecoDTO buscarPorId(Long Id) {
		return this.enderecoDTOConverter.toDTO(this.enderecoDAO.findById(Id));
	}

}
