package br.com.fatec.encomendas.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dto.CidadeDTO;
import br.com.fatec.encomendas.api.entity.Cidade;
import br.com.spektro.minispring.dto.DTOConverter;

public class CidadeDTOConverter implements DTOConverter<Cidade, CidadeDTO> {

	@Override
	public CidadeDTO toDTO(Cidade entidade) {
		CidadeDTO dto = new CidadeDTO();
		dto.setNome(entidade.name());
		dto.setValor(entidade.getValor());
		return dto;
	}

	public List<CidadeDTO> toDTO(List<Cidade> entidades) {
		List<CidadeDTO> dtos = Lists.newArrayList();
		for (Cidade entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	@Override
	public Cidade toEntity(CidadeDTO dto) {
		return null;
	}

	public List<Cidade> toEntity(List<CidadeDTO> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

}
