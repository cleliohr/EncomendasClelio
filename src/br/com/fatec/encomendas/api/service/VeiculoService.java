package br.com.fatec.encomendas.api.service;

import java.util.List;

import br.com.fatec.encomendas.api.dto.VeiculoDTO;

public interface VeiculoService {
	
	VeiculoDTO salvar (VeiculoDTO veiculo);
	
	void atualizar (VeiculoDTO veiculo);
	
	void deletar (Long Id);
	
	List<VeiculoDTO> listar();
	
	VeiculoDTO buscarPorId(Long Id);

}
