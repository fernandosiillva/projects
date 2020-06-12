package Investimentos;

public class Conservador implements Investimento{

	@Override
	public double investir(Conta conta) {
		return conta.getSaldo() * 0.008;
	}

}
