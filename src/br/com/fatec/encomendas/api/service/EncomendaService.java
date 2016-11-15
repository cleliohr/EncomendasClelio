package br.com.fatec.encomendas.api.service;

import java.util.List;

import br.com.fatec.encomendas.api.dto.EncomendaDTO;

public interface EncomendaService {

	EncomendaDTO salvar (EncomendaDTO encomenda);
	
	void atualizar (EncomendaDTO encomenda);
	
	void deletar (Long Id);
	
	List<EncomendaDTO> listar();
	
	EncomendaDTO buscarPorId(Long Id);

}
