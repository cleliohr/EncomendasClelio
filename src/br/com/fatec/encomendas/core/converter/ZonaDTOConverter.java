package br.com.fatec.encomendas.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dto.ZonaDTO;
import br.com.fatec.encomendas.api.entity.Zona;
import br.com.spektro.minispring.dto.DTOConverter;

public class ZonaDTOConverter implements DTOConverter<Zona, ZonaDTO> {

	public ZonaDTO toDTO(Zona entidade) {
		ZonaDTO dto = new ZonaDTO();
		dto.setId(entidade.getId());
		dto.setNome(entidade.getNome());
		return dto;
	}

	public List<ZonaDTO> toDTO(List<Zona> entidades) {
		List<ZonaDTO> dtos = Lists.newArrayList();
		for (Zona entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	public Zona toEntity(ZonaDTO dto) {
		Zona entidade = new Zona();
		entidade.setId(dto.getId());
		entidade.setNome(dto.getNome());
		return entidade;
	}

	public List<Zona> toEntity(List<ZonaDTO> dtos) {
		List<Zona> entidades = Lists.newArrayList();
		for (ZonaDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}
