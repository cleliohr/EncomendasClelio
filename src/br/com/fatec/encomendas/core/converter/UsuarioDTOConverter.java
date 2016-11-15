package br.com.fatec.encomendas.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.encomendas.api.dto.UsuarioDTO;
import br.com.fatec.encomendas.api.entity.Usuario;
import br.com.spektro.minispring.dto.DTOConverter;

public class UsuarioDTOConverter implements DTOConverter<Usuario, UsuarioDTO> {

	public UsuarioDTO toDTO(Usuario entidade) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(entidade.getId());
		dto.setNome(entidade.getNome());
		dto.setEndereco(entidade.getEndereco());
		dto.setNumero(entidade.getNumero());
		dto.setComplemento(entidade.getComplemento());
		dto.setCpf(entidade.getCpf());
		return dto;
	}

	public List<UsuarioDTO> toDTO(List<Usuario> entidades) {
		List<UsuarioDTO> dtos = Lists.newArrayList();
		for (Usuario entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	public Usuario toEntity(UsuarioDTO dto) {
		Usuario entidade = new Usuario();
		entidade.setId(dto.getId());
		entidade.setNome(dto.getNome());
		entidade.setEndereco(dto.getEndereco());
		entidade.setNumero(dto.getNumero());
		entidade.setComplemento(dto.getComplemento());
		entidade.setCpf(dto.getCpf());
		return entidade;
	}

	public List<Usuario> toEntity(List<UsuarioDTO> dtos) {
		List<Usuario> entidades = Lists.newArrayList();
		for (UsuarioDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}
