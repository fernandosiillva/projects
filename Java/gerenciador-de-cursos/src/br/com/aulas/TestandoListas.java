package br.com.aulas;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

	public static void main(String[] args) {

		String aula1 = "Modelando a classe aula";
		String aula2 = "Conhecendo mais de lista";
		String aula3 = "Trabalhando com Cursos e sets";
		
		ArrayList<String> aulas = new ArrayList<String>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		System.out.println(aulas);
		
		aulas.remove(0);
		System.out.println(aulas);
		
		for (String aula : aulas) {
			System.out.println("Aula: " + aula);
		}
		
		String primeiraAula = aulas.get(0);
		System.out.println(primeiraAula);
		
		for (int i = 0; i < aulas.size(); i++) {
			System.out.println("aulas: " + aulas.get(i));
		}
		
		aulas.forEach(aula -> {
			System.out.println("Percorrendo!");
			System.out.println("Aula " + aula);});
		
		Collections.sort(aulas);
		System.out.println("Depois de ordenado:");
		System.out.println(aulas);
	}

}
