package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {

	public static void main(String[] args) {
		
		List<Conta> lista = new ArrayList<Conta>();

        ArrayList<String> nomes = new ArrayList<String>();
		
		Conta cc = new ContaCorrente(10, 12);
		lista.add(cc);
		
		Conta cc2 = new ContaCorrente(20, 15);
		lista.add(cc2);
		
		System.out.println(lista.size());				 
		Conta ref = lista.get(0);		
		System.out.println(ref.getNumero());
		
		lista.remove(0);
		
		System.out.println("tamanho " + lista.size());
		
		Conta cc3 = new ContaCorrente(10, 12);
		lista.add(cc3);
		
		Conta cc4 = new ContaCorrente(20, 15);
		lista.add(cc4);
		
		for (int i = 0; i < lista.size(); i++) {
			Conta conta =  lista.get(i);
			System.out.println(conta);
		}
		
		System.out.println("------------------------");
		
		for (Conta conta : lista) {
			System.out.println(conta);
		}
	}

}
