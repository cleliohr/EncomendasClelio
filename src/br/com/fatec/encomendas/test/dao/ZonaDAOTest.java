package br.com.fatec.encomendas.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.encomendas.api.dao.ZonaDAO;
import br.com.fatec.encomendas.api.entity.Zona;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ZonaDAOTest {
	private ZonaDAO dao;
	
	@Before
	public void config(){
		this.dao = ImplFinder.getImpl(ZonaDAO.class);
	}
	
	@Test
	public void save(){
		Zona zona = new Zona(null, "SJC-Leste_Centro");
		
		Long zonaID = this.dao.save(zona);
		Zona zonaSalva = this.dao.findById(zonaID);
		
		Assert.assertEquals("SJC-Leste_Centro", zonaSalva.getNome());
	}
	
	@Test
	public void update(){
		Zona zona = new Zona(null, "SJC-Leste_Centro");
		
		Long zonaSalvaID = this.dao.save(zona);
		Zona zonaSalva = this.dao.findById(zonaSalvaID);
		
		zonaSalva.setNome("SJC-Leste");
		
		this.dao.update(zonaSalva);
		Zona zonaAtualizada = this.dao.findById(zonaSalvaID);
		
		Assert.assertEquals(zonaSalva.getId(), zonaAtualizada.getId());
		Assert.assertEquals("Adm", zonaAtualizada.getNome());
	}
	
	@Test
	public void delete(){
		Zona zona = new Zona(null, "SJC-Leste_Centro");
		
		Long zonaSalvaID = this.dao.save(zona);
		this.dao.delete(zonaSalvaID);
		Zona zonaDeletada = this.dao.findById(zonaSalvaID);
		
		Assert.assertNull(zonaDeletada);
	}
	
	@Test
	public void findAll(){
		Zona zona1 = new Zona(null, "Zona1");
		Zona zona2 = new Zona(null, "Zona2");
		Zona zona3 = new Zona(null, "Zona3");
		
		this.dao.save(zona1);
		this.dao.save(zona2);
		this.dao.save(zona3);
		
		List<Zona> zonas =  this.dao.findAll();
		
		Assert.assertEquals("SJC-Leste_Centro", zonas.get(0).getNome());
		Assert.assertEquals("SJC-Leste_Centro", zonas.get(1).getNome());
		Assert.assertEquals("SJC-Leste_Centro", zonas.get(2).getNome());
	}
}