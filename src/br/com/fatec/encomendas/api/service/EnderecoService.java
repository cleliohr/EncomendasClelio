package br.com.fatec.encomendas.api.service;

import java.util.List;

import br.com.fatec.encomendas.api.dto.EnderecoDTO;

public interface EnderecoService {
	
	EnderecoDTO salvar (EnderecoDTO endereco);
	
	void atualizar (EnderecoDTO endereco);
	
	void deletar (Long Id);
	
	List<EnderecoDTO> listar();
	
	EnderecoDTO buscarPorId(Long Id);

}
