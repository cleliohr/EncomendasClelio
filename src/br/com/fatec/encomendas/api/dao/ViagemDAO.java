package br.com.fatec.encomendas.api.dao;

import java.util.List;

import br.com.fatec.encomendas.api.entity.Viagem;

public interface ViagemDAO {
	Long save(Viagem viagem);
	
	void update(Viagem viagem);
	
	void delete(Long id);
	
	Viagem findById(Long id);
	
	List<Viagem> findAll();
}
