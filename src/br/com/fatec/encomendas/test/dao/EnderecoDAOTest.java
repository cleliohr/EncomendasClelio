package br.com.fatec.encomendas.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.encomendas.api.dao.EnderecoDAO;
import br.com.fatec.encomendas.api.entity.Cidade;
import br.com.fatec.encomendas.api.entity.Endereco;
import br.com.fatec.encomendas.api.entity.Zona;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class EnderecoDAOTest {
	private EnderecoDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(EnderecoDAO.class);
	}

	@Test
	public void save() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(null, "12221020", Cidade.SJC, "Rua Rubens Leitão Filho", "Vila Industrial",
				zona);

		Long enderecoID = this.dao.save(endereco);
		Endereco enderecoSalva = this.dao.findById(enderecoID);

		Assert.assertEquals(enderecoID, enderecoSalva.getId());
		Assert.assertEquals(Cidade.SJC, enderecoSalva.getCidade());
		Assert.assertEquals("Rua Rubens Leitão Filho", enderecoSalva.getLogradouro());
		Assert.assertEquals("Vila Industrial", enderecoSalva.getBairro());
		Assert.assertEquals(zona, enderecoSalva.getZona());
	}

	@Test
	public void update() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(null, "12221020", Cidade.SJC, "Rua Rubens Leitão Filho", "Vila Industrial",
				zona);

		Long enderecoID = this.dao.save(endereco);
		Endereco enderecoSalva = this.dao.findById(enderecoID);

		enderecoSalva.setLogradouro("Teste");
		this.dao.update(enderecoSalva);

		Assert.assertEquals(enderecoID, enderecoSalva.getId());
		Assert.assertEquals(Cidade.SJC, enderecoSalva.getCidade());
		Assert.assertEquals("Teste", enderecoSalva.getLogradouro());
		Assert.assertEquals("Vila Industrial", enderecoSalva.getBairro());
		Assert.assertEquals(zona, enderecoSalva.getZona());
	}

	@Test
	public void delete() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(null, "12221020", Cidade.SJC, "Rua Rubens Leitão Filho", "Vila Industrial",
				zona);

		Long enderecoID = this.dao.save(endereco);
		this.dao.delete(enderecoID);

		Endereco enderecoDeletada = this.dao.findById(enderecoID);

		Assert.assertNull(enderecoDeletada);
	}

	@Test
	public void findAll() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco1 = new Endereco(null, "12221020", Cidade.SJC, "Teste1", "Teste1", zona);
		Endereco endereco2 = new Endereco(null, "12221021", Cidade.SJC, "Teste2", "Teste2", zona);
		Endereco endereco3 = new Endereco(null, "12221022", Cidade.SJC, "Teste3", "Teste3", zona);

		this.dao.save(endereco1);
		this.dao.save(endereco2);
		this.dao.save(endereco3);

		List<Endereco> enderecos = this.dao.findAll();

		Assert.assertEquals("12221020", enderecos.get(0).getCep());
		Assert.assertEquals(Cidade.SJC, enderecos.get(0).getCidade());
		Assert.assertEquals("Teste1", enderecos.get(0).getLogradouro());
		Assert.assertEquals("Teste1", enderecos.get(0).getBairro());
		Assert.assertEquals(zona, enderecos.get(0).getZona());

		Assert.assertEquals("12221021", enderecos.get(1).getCep());
		Assert.assertEquals(Cidade.SJC, enderecos.get(1).getCidade());
		Assert.assertEquals("Teste2", enderecos.get(1).getLogradouro());
		Assert.assertEquals("Teste2", enderecos.get(1).getBairro());
		Assert.assertEquals(zona, enderecos.get(1).getZona());

		Assert.assertEquals("12221022", enderecos.get(2).getCep());
		Assert.assertEquals(Cidade.SJC, enderecos.get(2).getCidade());
		Assert.assertEquals("Teste3", enderecos.get(2).getLogradouro());
		Assert.assertEquals("Teste3", enderecos.get(2).getBairro());
		Assert.assertEquals(zona, enderecos.get(2).getZona());
	}
}
