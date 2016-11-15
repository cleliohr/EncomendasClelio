package br.com.fatec.encomendas.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dto.AgruparDTO;
import br.com.fatec.encomendas.api.entity.ViewAgrupar;
import br.com.spektro.minispring.dto.DTOConverter;

public class AgruparDTOConverter implements DTOConverter<ViewAgrupar, AgruparDTO> {

	public AgruparDTO toDTO(ViewAgrupar entidade) {
		AgruparDTO dto = new AgruparDTO();
		dto.setEncomendaDescricao(entidade.getEncomendaDescricao());
		dto.setUsuarioNome(entidade.getUsuarioNome());
		dto.setVeiculoNome(entidade.getVeiculoNome());
		dto.setStatus(entidade.getStatus());
		return dto;
	}

	public List<AgruparDTO> toDTO(List<ViewAgrupar> entidades) {
		List<AgruparDTO> dtos = Lists.newArrayList();
		for (ViewAgrupar entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	public ViewAgrupar toEntity(AgruparDTO dto) {
		ViewAgrupar entidade = new ViewAgrupar();
		entidade.setEncomendaDescricao(dto.getEncomendaDescricao());
		entidade.setUsuarioNome(dto.getUsuarioNome());
		entidade.setVeiculoNome(dto.getVeiculoNome());
		entidade.setStatus(dto.getStatus());
		return entidade;
	}

	public List<ViewAgrupar> toEntity(List<AgruparDTO> dtos) {
		List<ViewAgrupar> entidades = Lists.newArrayList();
		for (AgruparDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}
