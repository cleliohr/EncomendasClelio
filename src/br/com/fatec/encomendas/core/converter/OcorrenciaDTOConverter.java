package br.com.fatec.encomendas.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dto.OcorrenciaDTO;
import br.com.fatec.encomendas.api.entity.Ocorrencia;
import br.com.spektro.minispring.dto.DTOConverter;

public class OcorrenciaDTOConverter implements DTOConverter<Ocorrencia, OcorrenciaDTO> {

	public OcorrenciaDTO toDTO(Ocorrencia entidade) {
		OcorrenciaDTO dto = new OcorrenciaDTO();
		dto.setId(entidade.getId());
		dto.setEncomenda(entidade.getEncomenda());
		dto.setViagem(entidade.getViagem());
		dto.setDescricao(entidade.getDescricao());
		dto.setDataHora(entidade.getDataHora());
		dto.setTipoOcorrencia(entidade.getTipoOcorrencia());
		return dto;
	}

	public List<OcorrenciaDTO> toDTO(List<Ocorrencia> entidades) {
		List<OcorrenciaDTO> dtos = Lists.newArrayList();
		for (Ocorrencia entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	public Ocorrencia toEntity(OcorrenciaDTO dto) {
		Ocorrencia entidade = new Ocorrencia();
		entidade.setId(dto.getId());
		entidade.setEncomenda(dto.getEncomenda());
		entidade.setViagem(dto.getViagem());
		entidade.setDescricao(dto.getDescricao());
		entidade.setDataHora(dto.getDataHora());
		entidade.setTipoOcorrencia(dto.getTipoOcorrencia());
		return entidade;
	}

	public List<Ocorrencia> toEntity(List<OcorrenciaDTO> dtos) {
		List<Ocorrencia> entidades = Lists.newArrayList();
		for (OcorrenciaDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}
