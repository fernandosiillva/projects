package br.com.bytebank.banco.test;

import br.com.bytebank.banco.especial.ContaEspecial;
import br.com.bytebank.banco.modelo.*;

public class TesteContas {
	
	public static void main(String[] args) throws SaldoInsuficienteException{
		
		ContaEspecial ce = new ContaEspecial(50, 10);
		ce.getSaldo();
		
		ContaCorrente cc = new ContaCorrente(10, 123);
		cc.deposita(100.0);
		
		ContaPoupanca cp = new ContaPoupanca(20, 456);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);
		
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
	}
	
}
