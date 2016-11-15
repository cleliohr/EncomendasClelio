package br.com.fatec.encomendas.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.encomendas.api.dao.EncomendaDAO;
import br.com.fatec.encomendas.api.entity.Cidade;
import br.com.fatec.encomendas.api.entity.Encomenda;
import br.com.fatec.encomendas.api.entity.Endereco;
import br.com.fatec.encomendas.api.entity.Usuario;
import br.com.fatec.encomendas.api.entity.Zona;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class EncomendaDAOTest {
	private EncomendaDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(EncomendaDAO.class);
	}

	@Test
	public void save() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");
		Encomenda encomenda = new Encomenda(null, usuario, "Pendente", "Teste");

		Long encomendaID = this.dao.save(encomenda);
		Encomenda encomendaSalva = this.dao.findById(encomendaID);

		Assert.assertEquals(encomendaID, encomendaSalva.getId());
		Assert.assertEquals(usuario, encomendaSalva.getUsuario());
		Assert.assertEquals("Pendente", encomendaSalva.getStatus());
	}

	@Test
	public void update() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");
		Encomenda encomenda = new Encomenda(null, usuario, "Pendente", "Teste");

		Long encomendaID = this.dao.save(encomenda);
		Encomenda encomendaSalva = this.dao.findById(encomendaID);

		encomendaSalva.setStatus("Teste");
		this.dao.update(encomendaSalva);

		Assert.assertEquals(encomendaID, encomendaSalva.getId());
		Assert.assertEquals(usuario, encomendaSalva.getUsuario());
		Assert.assertEquals("Teste", encomendaSalva.getStatus());
	}

	@Test
	public void delete() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");
		Encomenda encomenda = new Encomenda(null, usuario, "Pendente", "Teste");

		Long encomendaID = this.dao.save(encomenda);
		this.dao.delete(encomendaID);

		Encomenda encomendaDeletada = this.dao.findById(encomendaID);

		Assert.assertNull(encomendaDeletada);
	}

	@Test
	public void findAll() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");
		Encomenda encomenda1 = new Encomenda(null, usuario, "Teste1", "Teste1");
		Encomenda encomenda2 = new Encomenda(null, usuario, "Teste2", "Teste2");
		Encomenda encomenda3 = new Encomenda(null, usuario, "Teste3", "Teste3");

		this.dao.save(encomenda1);
		this.dao.save(encomenda2);
		this.dao.save(encomenda3);

		List<Encomenda> encomendas = this.dao.findAll();

		Assert.assertEquals(usuario, encomendas.get(0).getUsuario());
		Assert.assertEquals("Teste1", encomendas.get(0).getStatus());

		Assert.assertEquals(usuario, encomendas.get(1).getUsuario());
		Assert.assertEquals("Teste2", encomendas.get(1).getStatus());

		Assert.assertEquals(usuario, encomendas.get(2).getUsuario());
		Assert.assertEquals("Teste3", encomendas.get(2).getStatus());
	}
}
