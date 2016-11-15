package br.com.fatec.encomendas.test.dao;

import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.encomendas.api.dao.OcorrenciaDAO;
import br.com.fatec.encomendas.api.entity.Cidade;
import br.com.fatec.encomendas.api.entity.Encomenda;
import br.com.fatec.encomendas.api.entity.Endereco;
import br.com.fatec.encomendas.api.entity.Ocorrencia;
import br.com.fatec.encomendas.api.entity.Usuario;
import br.com.fatec.encomendas.api.entity.Veiculo;
import br.com.fatec.encomendas.api.entity.Viagem;
import br.com.fatec.encomendas.api.entity.Zona;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class OcorrenciaDAOTest {
	private OcorrenciaDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(OcorrenciaDAO.class);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void save() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");
		Encomenda encomenda = new Encomenda(new Long(1), usuario, "Pendente", "Teste");
		Veiculo veiculo = new Veiculo(new Long(1), "Teste1", zona);
		Viagem viagem = new Viagem(null, veiculo, new Date(2016, 01, 21));
		Ocorrencia ocorrencia = new Ocorrencia(null, encomenda, viagem, "Destinatário não encontrado",
				new Date(2016, 01, 21), "Não-Entrega");

		Long ocorrenciaID = this.dao.save(ocorrencia);
		Ocorrencia ocorrenciaSalva = this.dao.findById(ocorrenciaID);

		Assert.assertEquals(ocorrenciaID, ocorrenciaSalva.getId());
		Assert.assertEquals(encomenda, ocorrenciaSalva.getEncomenda());
		Assert.assertEquals(viagem, ocorrenciaSalva.getViagem());
		Assert.assertEquals("Destinatário não encontrado", ocorrenciaSalva.getDescricao());
		Assert.assertEquals(new Date(2016, 01, 21), ocorrenciaSalva.getDataHora());
		Assert.assertEquals("Não-Entrega", ocorrenciaSalva.getTipoOcorrencia());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void update() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");
		Encomenda encomenda = new Encomenda(new Long(1), usuario, "Pendente", "Teste");
		Veiculo veiculo = new Veiculo(new Long(1), "Teste1", zona);
		Viagem viagem = new Viagem(null, veiculo, new Date(2016, 01, 21));
		Ocorrencia ocorrencia = new Ocorrencia(null, encomenda, viagem, "Destinatário não encontrado",
				new Date(2016, 01, 21), "Não-Entrega");

		Long ocorrenciaID = this.dao.save(ocorrencia);
		Ocorrencia ocorrenciaSalva = this.dao.findById(ocorrenciaID);

		ocorrenciaSalva.setDescricao("Teste");
		this.dao.update(ocorrenciaSalva);

		Assert.assertEquals(ocorrenciaID, ocorrenciaSalva.getId());
		Assert.assertEquals(encomenda, ocorrenciaSalva.getEncomenda());
		Assert.assertEquals(viagem, ocorrenciaSalva.getViagem());
		Assert.assertEquals("Teste", ocorrenciaSalva.getDescricao());
		Assert.assertEquals(new Date(2016, 01, 21), ocorrenciaSalva.getDataHora());
		Assert.assertEquals("Não-Entrega", ocorrenciaSalva.getTipoOcorrencia());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void delete() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");
		Encomenda encomenda = new Encomenda(new Long(1), usuario, "Pendente", "Teste");
		Veiculo veiculo = new Veiculo(new Long(1), "Teste1", zona);
		Viagem viagem = new Viagem(null, veiculo, new Date(2016, 01, 21));
		Ocorrencia ocorrencia = new Ocorrencia(null, encomenda, viagem, "Destinatário não encontrado",
				new Date(2016, 01, 21), "Não-Entrega");

		Long ocorrenciaID = this.dao.save(ocorrencia);
		this.dao.delete(ocorrenciaID);

		Ocorrencia ocorrenciaDeletada = this.dao.findById(ocorrenciaID);

		Assert.assertNull(ocorrenciaDeletada);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void findAll() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Endereco endereco = new Endereco(new Long(1), "12221020", Cidade.SJC, "Rua Rubens Leitão Filho",
				"Vila Industrial", zona);
		Usuario usuario = new Usuario(null, "Teste1", endereco, "208", null, "00000000000");
		Encomenda encomenda = new Encomenda(new Long(1), usuario, "Pendente", "Teste");
		Veiculo veiculo = new Veiculo(new Long(1), "Teste1", zona);
		Viagem viagem = new Viagem(null, veiculo, new Date(2016, 01, 21));
		Ocorrencia ocorrencia1 = new Ocorrencia(null, encomenda, viagem, "Encomenda enviada", new Date(2016, 01, 21),
				"Saída");
		Ocorrencia ocorrencia2 = new Ocorrencia(null, encomenda, viagem, "Destinatário não encontrado",
				new Date(2016, 01, 21), "Não-Entrega");
		Ocorrencia ocorrencia3 = new Ocorrencia(null, encomenda, viagem, "Entrega ao usuário", new Date(2016, 01, 21),
				"Entrega");

		this.dao.save(ocorrencia1);
		this.dao.save(ocorrencia2);
		this.dao.save(ocorrencia3);

		List<Ocorrencia> ocorrencias = this.dao.findAll();

		Assert.assertEquals(encomenda, ocorrencias.get(0).getEncomenda());
		Assert.assertEquals(viagem, ocorrencias.get(0).getViagem());
		Assert.assertEquals("Encomenda enviada", ocorrencias.get(0).getDescricao());
		Assert.assertEquals(new Date(2016, 01, 21), ocorrencias.get(0).getDataHora());
		Assert.assertEquals("Saída", ocorrencias.get(0).getTipoOcorrencia());

		Assert.assertEquals(encomenda, ocorrencias.get(1).getEncomenda());
		Assert.assertEquals(viagem, ocorrencias.get(1).getViagem());
		Assert.assertEquals("Destinatário não encontrado", ocorrencias.get(1).getDescricao());
		Assert.assertEquals(new Date(2016, 01, 21), ocorrencias.get(1).getDataHora());
		Assert.assertEquals("Não-Entrega", ocorrencias.get(1).getTipoOcorrencia());

		Assert.assertEquals(encomenda, ocorrencias.get(2).getEncomenda());
		Assert.assertEquals(viagem, ocorrencias.get(2).getViagem());
		Assert.assertEquals("Entrega ao usuário", ocorrencias.get(2).getDescricao());
		Assert.assertEquals(new Date(2016, 01, 21), ocorrencias.get(2).getDataHora());
		Assert.assertEquals("Entrega", ocorrencias.get(2).getTipoOcorrencia());
	}
}
