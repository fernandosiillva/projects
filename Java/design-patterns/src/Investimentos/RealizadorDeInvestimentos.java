package Investimentos;

public class RealizadorDeInvestimentos {

	public void investir(Conta conta, Investimento investimento) {
		double resultado = investimento.investir(conta);
		conta.deposita(resultado * 0.75);
		System.out.println("Novo saldo: " + conta.getSaldo());
	}
}
