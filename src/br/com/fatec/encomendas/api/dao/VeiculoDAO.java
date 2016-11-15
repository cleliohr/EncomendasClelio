package br.com.fatec.encomendas.api.dao;

import java.util.List;

import br.com.fatec.encomendas.api.entity.Veiculo;

public interface VeiculoDAO {
	Long save(Veiculo veiculo);
	
	void update(Veiculo veiculo);
	
	void delete(Long id);
	
	Veiculo findById(Long id);
	
	List<Veiculo> findAll();
}
