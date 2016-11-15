package br.com.fatec.encomendas.api.dao;

import java.util.List;

import br.com.fatec.encomendas.api.entity.Estado;

public interface EstadoDAO {
	
	Estado findById(Long id);
	
	List<Estado> findAll();
}
