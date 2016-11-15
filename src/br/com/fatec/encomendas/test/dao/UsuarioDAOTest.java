package br.com.fatec.encomendas.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.encomendas.api.dao.UsuarioDAO;
import br.com.fatec.encomendas.api.entity.Cidade;
import br.com.fatec.encomendas.api.entity.Endereco;
import br.com.fatec.encomendas.api.entity.Usuario;
import br.com.fatec.encomendas.api.entity.Zona;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class UsuarioDAOTest {
	private UsuarioDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(UsuarioDAO.class);
	}

	@Test
	public void save() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");

		Long usuarioID = this.dao.save(usuario);
		Usuario usuarioSalva = this.dao.findById(usuarioID);

		Assert.assertEquals(usuarioID, usuarioSalva.getId());
		Assert.assertEquals("Teste1", usuarioSalva.getNome());
		Assert.assertEquals(endereco, usuarioSalva.getEndereco());
		Assert.assertEquals("208", usuarioSalva.getNumero());
		Assert.assertEquals(null, usuarioSalva.getComplemento());
		Assert.assertEquals("00000000000", usuarioSalva.getCpf());
	}

	@Test
	public void update() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");

		Long usuarioID = this.dao.save(usuario);
		Usuario usuarioSalva = this.dao.findById(usuarioID);

		usuarioSalva.setNome("Teste");
		this.dao.update(usuarioSalva);

		Assert.assertEquals(usuarioID, usuarioSalva.getId());
		Assert.assertEquals("Teste", usuarioSalva.getNome());
		Assert.assertEquals(endereco, usuarioSalva.getEndereco());
		Assert.assertEquals("208", usuarioSalva.getNumero());
		Assert.assertEquals(null, usuarioSalva.getComplemento());
		Assert.assertEquals("00000000000", usuarioSalva.getCpf());
	}

	@Test
	public void delete() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");

		Long usuarioID = this.dao.save(usuario);
		this.dao.delete(usuarioID);

		Usuario usuarioDeletada = this.dao.findById(usuarioID);

		Assert.assertNull(usuarioDeletada);
	}

	@Test
	public void findAll() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario1 = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");
		Usuario usuario2 = new Usuario(null, "Teste2", endereco, "209", null, "00000000001");
		Usuario usuario3 = new Usuario(null, "Teste3", endereco, "210", null, "00000000002");

		this.dao.save(usuario1);
		this.dao.save(usuario2);
		this.dao.save(usuario3);

		List<Usuario> usuarios = this.dao.findAll();

		Assert.assertEquals("Teste1", usuarios.get(0).getNome());
		Assert.assertEquals(endereco, usuarios.get(0).getEndereco());
		Assert.assertEquals("208", usuarios.get(0).getNumero());
		Assert.assertEquals(null, usuarios.get(0).getComplemento());
		Assert.assertEquals("00000000000", usuarios.get(0).getCpf());

		Assert.assertEquals("Teste2", usuarios.get(1).getNome());
		Assert.assertEquals(endereco, usuarios.get(1).getEndereco());
		Assert.assertEquals("209", usuarios.get(1).getNumero());
		Assert.assertEquals(null, usuarios.get(1).getComplemento());
		Assert.assertEquals("00000000001", usuarios.get(1).getCpf());

		Assert.assertEquals("Teste3", usuarios.get(2).getNome());
		Assert.assertEquals(endereco, usuarios.get(2).getEndereco());
		Assert.assertEquals("210", usuarios.get(2).getNumero());
		Assert.assertEquals(null, usuarios.get(2).getComplemento());
		Assert.assertEquals("00000000002", usuarios.get(2).getCpf());
	}
}
