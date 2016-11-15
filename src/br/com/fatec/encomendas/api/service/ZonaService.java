package br.com.fatec.encomendas.api.service;

import java.util.List;

import br.com.fatec.encomendas.api.dto.ZonaDTO;

public interface ZonaService {
	
	ZonaDTO salvar (ZonaDTO zona);
	
	void atualizar (ZonaDTO zona);
	
	void deletar (Long Id);
	
	List <ZonaDTO> listar();
	
	ZonaDTO buscarPorId (Long Id);

}
