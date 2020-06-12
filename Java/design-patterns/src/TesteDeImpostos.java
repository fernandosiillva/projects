
public class TesteDeImpostos {

	public static void main(String[] args) {

		Imposto iss = new ISS();
		Imposto icms = new ICMS();
		
		Orcamento orcamento = new Orcamento(500.0);
		
		CalculadoraDeImpostos calculadoraDeImpostos = new CalculadoraDeImpostos();
		
//		ISS
		calculadoraDeImpostos.realizaCalculo(orcamento, iss);
//		ICMS
		calculadoraDeImpostos.realizaCalculo(orcamento, icms);
	}

}
