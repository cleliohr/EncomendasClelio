package br.com.fatec.encomendas.api.entity;

public enum Estado {
	AC("AC"), 
	AL("AC"), 
	AP("AC"), 
	AM("AC"), 
	BA("AC"), 
	CE("AC"), 
	DF("AC"), 
	ES("AC"), 
	GO("AC"), 
	MA("AC"), 
	MT("AC"), 
	MS("AC"), 
	MG("AC"), 
	PA("AC"), 
	PB("AC"), 
	PR("AC"), 
	PE("AC"), 
	PI("AC"), 
	RJ("AC"), 
	RN("AC"), 
	RS("AC"), 
	RO("AC"), 
	RR("AC"), 
	SC("AC"), 
	SP("AC"), 
	SE("AC"), 
	TO("AC");
		
	private final String valor;

	private Estado(String valor) {
		this.valor = valor;
	}
	
    public String getValor(){
    	return this.valor;
    }
}
