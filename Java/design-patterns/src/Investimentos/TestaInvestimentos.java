package Investimentos;

public class TestaInvestimentos {

	public static void main(String[] args) {

		Investimento conservador = new Conservador();
		Investimento moderado = new Moderado();
		Investimento arrojado = new Arrojado();
		
		Conta conta = new Conta();
		
		conta.deposita(500);
		
		RealizadorDeInvestimentos realizadorDeInvestimentos = new RealizadorDeInvestimentos();
		
		realizadorDeInvestimentos.investir(conta, moderado);
	}
}
