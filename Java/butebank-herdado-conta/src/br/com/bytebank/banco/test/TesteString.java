package br.com.bytebank.banco.test;

public class TesteString {

	public static void main(String[] args) {

//		String nome = "Mario"; // object literal
//		String outro = new String("Alura"); // má prática, sempre prefira a sintaxe literal
//
//		String novo = outro.replace("A", "a");
//
//		System.out.println(novo);
//		
//		String lower = nome.toLowerCase(); //também teste toUpperCase()
//
//		System.out.println(lower);
//		
//		char c = nome.charAt(3); //char i
//		System.out.println(c);
//
//		int pos = nome.indexOf("rio");
//		System.out.println(pos);
//
//		String sub = nome.substring(1);
//		System.out.println(sub);
		
//		String texto = "Socorram";
//		texto = texto.concat("-");
//		texto = texto.concat("me");
//		texto = texto.concat(", ");
//		texto = texto.concat("subi ");
//		texto = texto.concat("no ");
//		texto = texto.concat("ônibus ");
//		texto = texto.concat("em ");
//		texto = texto.concat("Marrocos");
//		System.out.println(texto);
		
		StringBuilder builder = new StringBuilder("Socorram");
		builder.append("-");
		builder.append("me");
		builder.append(", ");
		builder.append("subi ");
		builder.append("no ");
		builder.append("ônibus ");
		builder.append("em ");
		builder.append("Marrocos");
		String texto = builder.toString();
		System.out.println(texto);
		
		//CharSequence cs = new StringBuilder("também é uma sequencia de caracteres");
		
		String nome = "ALURA";
		CharSequence cs = new StringBuilder("al");

		nome = nome.replace("AL", cs);

		System.out.println(nome);
	}

}
