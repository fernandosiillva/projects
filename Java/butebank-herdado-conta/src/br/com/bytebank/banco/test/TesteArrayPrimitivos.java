package br.com.bytebank.banco.test;

public class TesteArrayPrimitivos {

	public static void main(String[] args) {

		int [] idades =  new int[5];
		
		for (int i = 0; i < idades.length; i++) {
			idades[i] = i * i;			

//			int idade1 = idades[i];

			System.out.println(idades[i]);			
		}
		
		
	}

}
