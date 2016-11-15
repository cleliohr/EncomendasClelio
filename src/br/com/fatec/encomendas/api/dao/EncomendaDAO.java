package br.com.fatec.encomendas.api.dao;

import java.util.List;

import br.com.fatec.encomendas.api.entity.Encomenda;

public interface EncomendaDAO {
	Long save(Encomenda encomenda);
	
	void update(Encomenda encomenda);
	
	void delete(Long id);
	
	Encomenda findById(Long id);
	
	List<Encomenda> findAll();
}
