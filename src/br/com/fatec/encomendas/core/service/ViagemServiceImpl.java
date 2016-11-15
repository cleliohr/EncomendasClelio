package br.com.fatec.encomendas.core.service;

import java.util.List;

import br.com.fatec.encomendas.api.dao.ViagemDAO;
import br.com.fatec.encomendas.api.dto.ViagemDTO;
import br.com.fatec.encomendas.api.entity.Viagem;
import br.com.fatec.encomendas.api.service.ViagemService;
import br.com.fatec.encomendas.core.converter.ViagemDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ViagemServiceImpl implements ViagemService {

	private ViagemDAO viagemDAO;
	private ViagemDTOConverter viagemDTOConverter;

	public ViagemServiceImpl() {
		this.viagemDAO = ImplFinder.getImpl(ViagemDAO.class);
		this.viagemDTOConverter = ImplFinder.getFinalImpl(ViagemDTOConverter.class);
	}

	@Override
	public ViagemDTO salvar(ViagemDTO viagemDTO) {
		Viagem viagemEntidade = this.viagemDTOConverter.toEntity(viagemDTO);
		Long id = this.viagemDAO.save(viagemEntidade);
		viagemDTO.setId(id);
		return viagemDTO;
	}

	@Override
	public void atualizar(ViagemDTO viagemDTO) {
		Viagem viagemEntidade = this.viagemDTOConverter.toEntity(viagemDTO);
		this.viagemDAO.update(viagemEntidade);
	}

	@Override
	public void deletar(Long Id) {
		this.viagemDAO.delete(Id);
	}

	@Override
	public List<ViagemDTO> listar() {
		return this.viagemDTOConverter.toDTO(this.viagemDAO.findAll());
	}

	@Override
	public ViagemDTO buscarPorId(Long Id) {
		return this.viagemDTOConverter.toDTO(this.viagemDAO.findById(Id));
	}

}
