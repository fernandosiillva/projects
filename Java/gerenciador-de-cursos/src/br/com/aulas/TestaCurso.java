package br.com.aulas;

public class TestaCurso {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Fernando Bezerra");
		
//		List<Aula> aulas = javaColecoes.getAulas();
//		System.out.println(aulas);
		
//		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
//		System.out.println(aulas);
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList",21));
		javaColecoes.adiciona(new Aula("Criando uma Aula",20));
		javaColecoes.adiciona(new Aula("Modelando com coleções",24));
		
		javaColecoes.getAulas().add(new Aula("TESTE", 10));
		
		System.out.println(javaColecoes.getAulas());
	}

}
