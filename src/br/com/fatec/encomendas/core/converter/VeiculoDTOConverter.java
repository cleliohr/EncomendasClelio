package br.com.fatec.encomendas.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dto.VeiculoDTO;
import br.com.fatec.encomendas.api.entity.Veiculo;
import br.com.spektro.minispring.dto.DTOConverter;

public class VeiculoDTOConverter implements DTOConverter<Veiculo, VeiculoDTO> {

	public VeiculoDTO toDTO(Veiculo entidade) {
		VeiculoDTO dto = new VeiculoDTO();
		dto.setId(entidade.getId());
		dto.setNome(entidade.getNome());
		dto.setZona(entidade.getZona());
		return dto;
	}

	public List<VeiculoDTO> toDTO(List<Veiculo> entidades) {
		List<VeiculoDTO> dtos = Lists.newArrayList();
		for (Veiculo entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	public Veiculo toEntity(VeiculoDTO dto) {
		Veiculo entidade = new Veiculo();
		entidade.setId(dto.getId());
		entidade.setNome(dto.getNome());
		entidade.setZona(dto.getZona());
		return entidade;
	}

	public List<Veiculo> toEntity(List<VeiculoDTO> dtos) {
		List<Veiculo> entidades = Lists.newArrayList();
		for (VeiculoDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}
