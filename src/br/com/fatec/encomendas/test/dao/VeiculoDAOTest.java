package br.com.fatec.encomendas.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.encomendas.api.dao.VeiculoDAO;
import br.com.fatec.encomendas.api.entity.Veiculo;
import br.com.fatec.encomendas.api.entity.Zona;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class VeiculoDAOTest {
	private VeiculoDAO dao;
	
	@Before
	public void config(){
		this.dao = ImplFinder.getImpl(VeiculoDAO.class);
	}
	
	@Test
	public void save(){
		Zona zona = new Zona(new Long(1), "Teste1");
		Veiculo veiculo = new Veiculo(null, "Teste1", zona);
		
		Long veiculoID = this.dao.save(veiculo);
		Veiculo veiculoSalva = this.dao.findById(veiculoID);
		
		Assert.assertEquals(veiculoID, veiculoSalva.getId());
		Assert.assertEquals("Teste1", veiculoSalva.getNome());
		Assert.assertEquals(zona, veiculoSalva.getZona());
	}
	
	@Test
	public void update(){
		Zona zona = new Zona(new Long(1), "Teste1");
		Veiculo veiculo = new Veiculo(null, "Teste1", zona);
		
		Long veiculoID = this.dao.save(veiculo);
		Veiculo veiculoSalva = this.dao.findById(veiculoID);
		
		veiculoSalva.setNome("Teste");
		this.dao.update(veiculoSalva);
		
		Assert.assertEquals(veiculoID, veiculoSalva.getId());
		Assert.assertEquals("Teste1", veiculoSalva.getNome());
		Assert.assertEquals(zona, veiculoSalva.getZona());
	}
	
	@Test
	public void delete(){
		Zona zona = new Zona(new Long(1), "Teste1");
		Veiculo veiculo = new Veiculo(null, "Teste1", zona);
		
		Long veiculoID = this.dao.save(veiculo);
		this.dao.delete(veiculoID);
		
		Veiculo veiculoDeletada = this.dao.findById(veiculoID);
		
		Assert.assertNull(veiculoDeletada);
	}
	
	@Test
	public void findAll(){
		Zona zona = new Zona(new Long(1), "Teste1");
		Veiculo veiculo1 = new Veiculo(null, "Teste1", zona);
		Veiculo veiculo2 = new Veiculo(null, "Teste2", zona);
		Veiculo veiculo3 = new Veiculo(null, "Teste3", zona);
		
		this.dao.save(veiculo1);
		this.dao.save(veiculo2);
		this.dao.save(veiculo3);
		
		List<Veiculo> veiculos =  this.dao.findAll();
		
		Assert.assertEquals(zona, veiculos.get(0).getZona());
		Assert.assertEquals("Teste1", veiculos.get(0).getNome());
		
		Assert.assertEquals(zona, veiculos.get(1).getZona());
		Assert.assertEquals("Teste2", veiculos.get(1).getNome());
		
		Assert.assertEquals(zona, veiculos.get(2).getZona());
		Assert.assertEquals("Teste3", veiculos.get(2).getNome());
	}
}
