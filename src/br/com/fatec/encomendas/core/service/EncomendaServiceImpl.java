package br.com.fatec.encomendas.core.service;

import java.util.List;

import br.com.fatec.encomendas.api.dao.EncomendaDAO;
import br.com.fatec.encomendas.api.dto.EncomendaDTO;
import br.com.fatec.encomendas.api.entity.Encomenda;
import br.com.fatec.encomendas.api.service.EncomendaService;
import br.com.fatec.encomendas.core.converter.EncomendaDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class EncomendaServiceImpl implements EncomendaService {

	private EncomendaDAO encomendaDAO;
	private EncomendaDTOConverter encomendaDTOConverter;

	public EncomendaServiceImpl() {
		this.encomendaDAO = ImplFinder.getImpl(EncomendaDAO.class);
		this.encomendaDTOConverter = ImplFinder.getFinalImpl(EncomendaDTOConverter.class);
	}

	public EncomendaDTO salvar(EncomendaDTO encomendaDTO) {
		Encomenda encomendaEntidade = this.encomendaDTOConverter.toEntity(encomendaDTO);
		Long id = this.encomendaDAO.save(encomendaEntidade);
		encomendaDTO.setId(id);
		return encomendaDTO;
	}

	@Override
	public void atualizar(EncomendaDTO encomendaDTO) {
		Encomenda encomendaEntidade = this.encomendaDTOConverter.toEntity(encomendaDTO);
		this.encomendaDAO.update(encomendaEntidade);
	}

	@Override
	public void deletar(Long Id) {
		this.encomendaDAO.delete(Id);
	}

	@Override
	public List<EncomendaDTO> listar() {
		return this.encomendaDTOConverter.toDTO(this.encomendaDAO.findAll());
	}

	@Override
	public EncomendaDTO buscarPorId(Long Id) {
		return this.encomendaDTOConverter.toDTO(this.encomendaDAO.findById(Id));
	}

}
