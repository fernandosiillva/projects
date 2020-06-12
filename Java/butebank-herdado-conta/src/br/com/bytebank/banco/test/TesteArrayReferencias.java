package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayReferencias {

	public static void main(String[] args) {

		//int[] idades = new int[5];
		Object[] referencias = new Object[5];
		
		ContaCorrente cc1 = new ContaCorrente(10, 20);		
		referencias[0] = cc1;
		
		ContaPoupanca cc2 = new ContaPoupanca(30, 40);
		referencias[1] = cc2;
		
		Cliente cliente = new Cliente();
		referencias[2] = cliente;
		
		System.out.println(cc2.getNumero());
		
//		System.out.println(referencias[0].getNumero());
//		System.out.println(referencias[1].getNumero());
		
		ContaPoupanca ref = (ContaPoupanca) referencias[1];//type cast		
		
		System.out.println(ref.getNumero());
	}

}
