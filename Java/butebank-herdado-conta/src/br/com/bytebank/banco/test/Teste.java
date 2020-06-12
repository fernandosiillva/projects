package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeContas;

public class Teste {

	public static void main(String[] args) {

		GuardadorDeContas guardador = new GuardadorDeContas();
		
		Conta cc1 = new ContaCorrente(10, 22);		
		guardador.adiciona(cc1);
		
		Conta cc2 = new ContaCorrente(33, 55);
		guardador.adiciona(cc2);
		
		int tamanho = guardador.getQuantidadeDeElemento();
		System.out.println(tamanho);
		
		Conta ref = guardador.getReferencia(1);
		System.out.println(ref.getNumero());
	}

}
