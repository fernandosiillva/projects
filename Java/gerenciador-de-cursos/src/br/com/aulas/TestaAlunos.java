package br.com.aulas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestaAlunos {

	public static void main(String[] args) {

		Collection<String> alunos = new HashSet<>();
		
		List<String> alunosEmLista = new ArrayList<>(alunos);
		
		alunos.add("Rodrigo Turino");
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
		alunos.add("Nico Steppat");
		alunos.add("Sergio Lopes");
        alunos.add("Renan Saggio");
        alunos.add("Mauricio Aniche");
        
        boolean fernandoEstaMatriculado = alunos.contains("Fernando");
        
        System.out.println(fernandoEstaMatriculado);
        
        for (String aluno : alunos) {
			System.out.println(aluno);
		}
        
		System.out.println(alunos);
	}

}
