package br.com.fatec.encomendas.core.service;

import java.util.List;

import br.com.fatec.encomendas.api.dao.VeiculoDAO;
import br.com.fatec.encomendas.api.dto.VeiculoDTO;
import br.com.fatec.encomendas.api.entity.Veiculo;
import br.com.fatec.encomendas.api.service.VeiculoService;
import br.com.fatec.encomendas.core.converter.VeiculoDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class VeiculoServiceImpl implements VeiculoService {

	private VeiculoDAO veiculoDAO;
	private VeiculoDTOConverter veiculoDTOConverter;

	public VeiculoServiceImpl() {
		this.veiculoDAO = ImplFinder.getImpl(VeiculoDAO.class);
		this.veiculoDTOConverter = ImplFinder.getFinalImpl(VeiculoDTOConverter.class);
	}

	@Override
	public VeiculoDTO salvar(VeiculoDTO veiculoDTO) {
		Veiculo veiculoEntidade = this.veiculoDTOConverter.toEntity(veiculoDTO);
		Long id = this.veiculoDAO.save(veiculoEntidade);
		veiculoDTO.setId(id);
		return veiculoDTO;
	}

	@Override
	public void atualizar(VeiculoDTO veiculoDTO) {
		Veiculo veiculoEntidade = this.veiculoDTOConverter.toEntity(veiculoDTO);
		this.veiculoDAO.update(veiculoEntidade);
	}

	@Override
	public void deletar(Long Id) {
		this.veiculoDAO.delete(Id);
	}

	@Override
	public List<VeiculoDTO> listar() {
		return this.veiculoDTOConverter.toDTO(this.veiculoDAO.findAll());
	}

	@Override
	public VeiculoDTO buscarPorId(Long Id) {
		return this.veiculoDTOConverter.toDTO(this.veiculoDAO.findById(Id));
	}

}
