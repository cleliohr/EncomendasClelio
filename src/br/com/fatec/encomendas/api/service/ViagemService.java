package br.com.fatec.encomendas.api.service;

import java.util.List;

import br.com.fatec.encomendas.api.dto.ViagemDTO;

public interface ViagemService {
	
	ViagemDTO salvar (ViagemDTO viagem);
	
	void atualizar (ViagemDTO viagem);
	
	void deletar (Long Id);
	
	List<ViagemDTO> listar();
	
	ViagemDTO buscarPorId(Long Id);

}
