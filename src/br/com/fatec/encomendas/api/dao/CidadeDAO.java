package br.com.fatec.encomendas.api.dao;

import java.util.List;

import br.com.fatec.encomendas.api.entity.Cidade;
import br.com.fatec.encomendas.api.entity.Encomenda;

public interface CidadeDAO {
	Long save(Cidade cidade);
	
	void update(Cidade cidade);
	
	void delete(Long id);
	
	Cidade findById(Long id);
	
	List<Encomenda> findAll();
}
