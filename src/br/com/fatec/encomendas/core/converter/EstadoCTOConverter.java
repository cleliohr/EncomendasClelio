package br.com.fatec.encomendas.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dto.EstadoDTO;
import br.com.fatec.encomendas.api.entity.Estado;
import br.com.spektro.minispring.dto.DTOConverter;

public class EstadoCTOConverter implements DTOConverter<Estado, EstadoDTO> {

	@Override
	public EstadoDTO toDTO(Estado entidade) {
		EstadoDTO dto = new EstadoDTO();
		dto.setNome(entidade.name());
		dto.setValor(entidade.getValor());
		return dto;
	}

	public List<EstadoDTO> toDTO(List<Estado> entidades) {
		List<EstadoDTO> dtos = Lists.newArrayList();
		for (Estado entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	@Override
	public Estado toEntity(EstadoDTO arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Estado> toEntity(List<EstadoDTO> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
