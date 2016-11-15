package br.com.fatec.encomendas.core.service;

import java.util.List;

import br.com.fatec.encomendas.api.dao.OcorrenciaDAO;
import br.com.fatec.encomendas.api.dto.OcorrenciaDTO;
import br.com.fatec.encomendas.api.entity.Ocorrencia;
import br.com.fatec.encomendas.api.service.OcorrenciaService;
import br.com.fatec.encomendas.core.converter.OcorrenciaDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class OcorrenciaServiceImpl implements OcorrenciaService {

	private OcorrenciaDAO ocorrenciaDAO;
	private OcorrenciaDTOConverter ocorrenciaDTOConverter;

	public OcorrenciaServiceImpl() {
		this.ocorrenciaDAO = ImplFinder.getImpl(OcorrenciaDAO.class);
		this.ocorrenciaDTOConverter = ImplFinder.getFinalImpl(OcorrenciaDTOConverter.class);
	}

	@Override
	public OcorrenciaDTO salvar(OcorrenciaDTO ocorrenciaDTO) {
		Ocorrencia ocorrenciaEntidade = this.ocorrenciaDTOConverter.toEntity(ocorrenciaDTO);
		Long id = this.ocorrenciaDAO.save(ocorrenciaEntidade);
		ocorrenciaDTO.setId(id);
		return ocorrenciaDTO;
	}

	@Override
	public void atualizar(OcorrenciaDTO ocorrenciaDTO) {
		Ocorrencia ocorrenciaEntidade = this.ocorrenciaDTOConverter.toEntity(ocorrenciaDTO);
		this.ocorrenciaDAO.update(ocorrenciaEntidade);
	}

	@Override
	public void deletar(Long Id) {
		this.ocorrenciaDAO.delete(Id);
	}

	@Override
	public List<OcorrenciaDTO> listar() {
		return this.ocorrenciaDTOConverter.toDTO(this.ocorrenciaDAO.findAll());
	}

	@Override
	public OcorrenciaDTO buscarPorId(Long Id) {
		return this.ocorrenciaDTOConverter.toDTO(this.ocorrenciaDAO.findById(Id));
	}

	@Override
	public List<OcorrenciaDTO> listarPorEncomenda(Long idEncomenda) {
		return this.ocorrenciaDTOConverter.toDTO(this.ocorrenciaDAO.findByEncomenda(idEncomenda));
	}

}
