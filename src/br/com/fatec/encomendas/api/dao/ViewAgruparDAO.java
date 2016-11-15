package br.com.fatec.encomendas.api.dao;

import java.util.List;

import br.com.fatec.encomendas.api.entity.ViewAgrupar;

public interface ViewAgruparDAO {
	List<ViewAgrupar> findAll();
}
