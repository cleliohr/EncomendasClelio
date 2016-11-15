package br.com.fatec.encomendas.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dto.EncomendaDTO;
import br.com.fatec.encomendas.api.entity.Encomenda;
import br.com.spektro.minispring.dto.DTOConverter;

public class EncomendaDTOConverter implements DTOConverter<Encomenda, EncomendaDTO> {

	public EncomendaDTO toDTO(Encomenda entidade) {
		EncomendaDTO dto = new EncomendaDTO();
		dto.setId(entidade.getId());
		dto.setUsuario(entidade.getUsuario());
		dto.setStatus(entidade.getStatus());
		dto.setDescricao(entidade.getDescricao());
		return dto;
	}

	public List<EncomendaDTO> toDTO(List<Encomenda> entidades) {
		List<EncomendaDTO> dtos = Lists.newArrayList();
		for (Encomenda entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	public Encomenda toEntity(EncomendaDTO dto) {
		Encomenda entidade = new Encomenda();
		entidade.setId(dto.getId());
		entidade.setUsuario(dto.getUsuario());
		entidade.setStatus(dto.getStatus());
		entidade.setDescricao(dto.getDescricao());
		return entidade;
	}

	public List<Encomenda> toEntity(List<EncomendaDTO> dtos) {
		List<Encomenda> entidades = Lists.newArrayList();
		for (EncomendaDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}
