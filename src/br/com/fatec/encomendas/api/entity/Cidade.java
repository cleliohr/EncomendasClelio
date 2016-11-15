package br.com.fatec.encomendas.api.entity;

public enum Cidade {
	SJC("São José dos Campos");
	
	/*public static final String TABLE = "CIDADE";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";*/
	
	//private final Long id;
	private final String valor;

	/*private CidadeDTO(Long id, String valor) {
		this.id = id;
		this.campo = valor;
	}*/
	private Cidade(String campo) {
		this.valor = campo;
	}
	
	/*public Long getId(){
    	return this.id;
    }*/
	
    public String getValor(){
    	return this.valor;
    }
}
