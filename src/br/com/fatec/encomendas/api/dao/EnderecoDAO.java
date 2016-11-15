package br.com.fatec.encomendas.api.dao;

import java.util.List;

import br.com.fatec.encomendas.api.entity.Endereco;

public interface EnderecoDAO {
	Long save(Endereco endereco);
	
	void update(Endereco endereco);
	
	void delete(Long id);
	
	Endereco findById(Long id);
	
	List<Endereco> findAll();
}
