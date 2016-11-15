package br.com.fatec.encomendas.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dto.ViagemDTO;
import br.com.fatec.encomendas.api.entity.Viagem;
import br.com.spektro.minispring.dto.DTOConverter;

public class ViagemDTOConverter implements DTOConverter<Viagem, ViagemDTO> {

	public ViagemDTO toDTO(Viagem entidade) {
		ViagemDTO dto = new ViagemDTO();
		dto.setId(entidade.getId());
		dto.setVeiculo(entidade.getVeiculo());
		dto.setData(entidade.getData());
		return dto;
	}

	public List<ViagemDTO> toDTO(List<Viagem> entidades) {
		List<ViagemDTO> dtos = Lists.newArrayList();
		for (Viagem entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	public Viagem toEntity(ViagemDTO dto) {
		Viagem entidade = new Viagem();
		entidade.setId(dto.getId());
		entidade.setVeiculo(dto.getVeiculo());
		entidade.setData(dto.getData());
		return entidade;
	}

	public List<Viagem> toEntity(List<ViagemDTO> dtos) {
		List<Viagem> entidades = Lists.newArrayList();
		for (ViagemDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}
