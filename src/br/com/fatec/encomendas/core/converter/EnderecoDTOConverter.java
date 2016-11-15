package br.com.fatec.encomendas.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dto.CidadeDTO;
import br.com.fatec.encomendas.api.dto.EnderecoDTO;
import br.com.fatec.encomendas.api.entity.Cidade;
import br.com.fatec.encomendas.api.entity.Endereco;
import br.com.spektro.minispring.dto.DTOConverter;

public class EnderecoDTOConverter implements DTOConverter<Endereco, EnderecoDTO> {

	public EnderecoDTO toDTO(Endereco entidade) {
		EnderecoDTO dto = new EnderecoDTO();
		dto.setId(entidade.getId());
		dto.setCep(entidade.getCep());
		dto.setCidade(new CidadeDTO(entidade.getCidade().name(), entidade.getCidade().getValor()));
		dto.setLogradouro(entidade.getLogradouro());
		dto.setBairro(entidade.getBairro());
		dto.setZona(entidade.getZona());
		return dto;
	}

	public List<EnderecoDTO> toDTO(List<Endereco> entidades) {
		List<EnderecoDTO> dtos = Lists.newArrayList();
		for (Endereco entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	public Endereco toEntity(EnderecoDTO dto) {
		Endereco entidade = new Endereco();
		entidade.setId(dto.getId());
		entidade.setCep(dto.getCep());
		;
		entidade.setCidade(Cidade.valueOf(dto.getCidade().getNome()));
		entidade.setLogradouro(dto.getLogradouro());
		entidade.setBairro(dto.getBairro());
		entidade.setZona(dto.getZona());
		return entidade;
	}

	public List<Endereco> toEntity(List<EnderecoDTO> dtos) {
		List<Endereco> entidades = Lists.newArrayList();
		for (EnderecoDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}
