package br.com.fatec.encomendas.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.encomendas.api.dto.ZonaDTO;


public class ContextoZona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5094533222821621923L;

	private ZonaDTO zona;
	private List<ZonaDTO> zonas;
	
	
	public ZonaDTO getZona() {
		return this.zona;
	}
	public void setZona(ZonaDTO zona) {
		this.zona = zona;
	}
	public List<ZonaDTO> getZonas() {
		return this.zonas;
	}
	public void setZonas(List<ZonaDTO> zonas) {
		this.zonas = zonas;
	}
	
	
}
