package br.com.aulas;

public class TestaCurso2 {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Fernando Bezerra");
		
		
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList",21));
		javaColecoes.adiciona(new Aula("Criando uma Aula",20));
		javaColecoes.adiciona(new Aula("Modelando com coleções",24));

		System.out.println(javaColecoes);
		
		//		List<Aula> aulasImutaveis = javaColecoes.getAulas();
//		System.out.println(aulasImutaveis);
//		
//		List<Aula> aulas = new ArrayList<>(aulasImutaveis);
//		
//		Collections.sort(aulas);
//		System.out.println(aulas);
//		
//		System.out.println(javaColecoes.getTempoTotal());
	}

}
