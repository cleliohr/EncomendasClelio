package br.com.fatec.encomendas.core.service;

import java.util.List;

import br.com.fatec.encomendas.api.dao.ZonaDAO;
import br.com.fatec.encomendas.api.dto.ZonaDTO;
import br.com.fatec.encomendas.api.entity.Zona;
import br.com.fatec.encomendas.api.service.ZonaService;
import br.com.fatec.encomendas.core.converter.ZonaDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ZonaServiceImpl implements ZonaService {

	private ZonaDAO zonaDAO;
	private ZonaDTOConverter zonaDTOConverter;

	public ZonaServiceImpl() {
		this.zonaDAO = ImplFinder.getImpl(ZonaDAO.class);
		this.zonaDTOConverter = ImplFinder.getFinalImpl(ZonaDTOConverter.class);
	}

	@Override
	public ZonaDTO salvar(ZonaDTO zonaDTO) {
		Zona zonaEntidade = this.zonaDTOConverter.toEntity(zonaDTO);
		Long id = this.zonaDAO.save(zonaEntidade);
		zonaDTO.setId(id);
		return zonaDTO;
	}

	@Override
	public void atualizar(ZonaDTO zonaDTO) {
		Zona zonaEntidade = this.zonaDTOConverter.toEntity(zonaDTO);
		this.zonaDAO.update(zonaEntidade);
	}

	@Override
	public void deletar(Long Id) {
		this.zonaDAO.delete(Id);
	}

	@Override
	public List<ZonaDTO> listar() {
		return this.zonaDTOConverter.toDTO(this.zonaDAO.findAll());
	}

	@Override
	public ZonaDTO buscarPorId(Long Id) {
		return this.zonaDTOConverter.toDTO(this.zonaDAO.findById(Id));
	}

}
