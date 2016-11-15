package br.com.fatec.encomendas.api.service;

import java.util.List;

import br.com.fatec.encomendas.api.dto.AgruparDTO;

public interface AgrupamentoService {

	boolean agrupar();

	List<AgruparDTO> listar();

}
