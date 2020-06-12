package Investimentos;

public class Conta {

	private double saldo;
	
	public void deposita (double saldo) {
		this.saldo += saldo;
	}

	public double getSaldo() {
		return saldo;
	}	
}
