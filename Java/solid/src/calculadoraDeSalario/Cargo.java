package calculadoraDeSalario;

public enum Cargo {

	DESENVOLVEDOR(new DezOuVinteProCento()),
	DBA(new QuinzeOuVinteCincoPorCento());
	
	private RegraDeCalculo regra;
	
	Cargo(RegraDeCalculo regra){
		this.regra = regra;
	}
	
	public RegraDeCalculo getRegra() {
		return this.regra;
	}
}
