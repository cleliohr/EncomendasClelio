package br.com.fatec.encomendas.test.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.encomendas.api.dao.ViagemDAO;
import br.com.fatec.encomendas.api.entity.Veiculo;
import br.com.fatec.encomendas.api.entity.Viagem;
import br.com.fatec.encomendas.api.entity.Zona;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ViagemDAOTest {
	private ViagemDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(ViagemDAO.class);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void save() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Veiculo veiculo = new Veiculo(new Long(1), "Teste1", zona);
		Viagem viagem = new Viagem(null, veiculo, new Date(2016, 01, 21));

		Long viagemID = this.dao.save(viagem);
		Viagem viagemSalva = this.dao.findById(viagemID);

		Assert.assertEquals(viagemID, viagemSalva.getId());
		Assert.assertEquals(viagem.getVeiculo().getId(), viagemSalva.getVeiculo().getId());
		Assert.assertEquals(new Time(20, 30, 00), viagemSalva.getData());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void update() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Veiculo veiculo = new Veiculo(new Long(1), "Teste1", zona);
		Viagem viagem = new Viagem(null, veiculo, new Date(2016, 01, 21));

		Long viagemID = this.dao.save(viagem);
		Viagem viagemSalva = this.dao.findById(viagemID);

		viagemSalva.setData(new Time(20, 00, 00));

		this.dao.update(viagemSalva);
		Viagem viagemAtualizada = this.dao.findById(viagemID);

		Assert.assertEquals(viagemSalva.getId(), viagemAtualizada.getId());
		Assert.assertEquals(new Time(20, 00, 00), viagemAtualizada.getData());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void delete() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Veiculo veiculo = new Veiculo(new Long(1), "Teste1", zona);
		Viagem viagem = new Viagem(null, veiculo, new Date(2016, 01, 21));

		Long viagemID = this.dao.save(viagem);
		this.dao.delete(viagemID);
		Viagem viagemDeletada = this.dao.findById(viagemID);

		Assert.assertNull(viagemDeletada);
	}

	@Test
	@SuppressWarnings("deprecation")
	public void findAll() {
		Zona zona = new Zona(new Long(1), "Teste1");
		Veiculo veiculo = new Veiculo(new Long(1), "Teste1", zona);

		Viagem viagem1 = new Viagem(null, veiculo, new Date(2016, 01, 21));
		Viagem viagem2 = new Viagem(null, veiculo, new Date(2016, 01, 22));
		Viagem viagem3 = new Viagem(null, veiculo, new Date(2016, 01, 23));

		this.dao.save(viagem1);
		this.dao.save(viagem2);
		this.dao.save(viagem3);

		List<Viagem> viagens = this.dao.findAll();

		Assert.assertEquals(veiculo, viagens.get(0).getVeiculo());
		Assert.assertEquals(new Time(19, 00, 00), viagens.get(0).getData());

		Assert.assertEquals(veiculo, viagens.get(1).getVeiculo());
		Assert.assertEquals(new Time(19, 30, 00), viagens.get(1).getData());

		Assert.assertEquals(veiculo, viagens.get(2).getVeiculo());
		Assert.assertEquals(new Time(20, 00, 00), viagens.get(2).getData());
	}
}