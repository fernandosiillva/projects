package br.com.aulas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAula {

	public static void main(String[] args) {

		Aula a1 = new Aula("Revisando as ArrayLists", 21);
		Aula a2 = new Aula("Listas de objetos", 20);
		Aula a3 = new Aula("Relacionamento de listas e objetos", 15);
		
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);	

		// nates de ordenar
		System.out.println(aulas);
		
//		Collections.sort(aulas);
		aulas.sort(Comparator.comparing(Aula::getTempo));
		
		// depois de ordenar
		System.out.println(aulas);
	}

}
