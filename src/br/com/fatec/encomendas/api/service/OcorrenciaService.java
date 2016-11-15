package br.com.fatec.encomendas.api.service;

import java.util.List;

import br.com.fatec.encomendas.api.dto.OcorrenciaDTO;

public interface OcorrenciaService {

	OcorrenciaDTO salvar(OcorrenciaDTO ocorrencia);

	void atualizar(OcorrenciaDTO ocorrencia);

	void deletar(Long Id);

	List<OcorrenciaDTO> listar();

	OcorrenciaDTO buscarPorId(Long Id);

	List<OcorrenciaDTO> listarPorEncomenda(Long idEncomenda);

}
