package br.com.fatec.encomendas.api.dao;

import java.util.List;

import br.com.fatec.encomendas.api.entity.Zona;

public interface ZonaDAO {
	Long save(Zona zona);
	
	void update(Zona zona);
	
	void delete(Long id);
	
	Zona findById(Long id);
	
	List<Zona> findAll();
}
