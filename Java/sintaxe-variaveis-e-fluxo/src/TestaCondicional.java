
public class TestaCondicional {

	public static void main(String[] args) {

		System.out.println("testentando condicionais");

		int idade = 16;
		int quantidadePessoas = 3;
		if (idade >= 18) {
			System.out.println("Vc tem mais de 18 anos");
			System.out.println("Seja bem vindo");
		} else {
			if (quantidadePessoas >= 2) {
				System.out.println("Vc não tem 18, mas pode"
						+ " entrar pois esta acompanhado");
			} else {
				System.out.println("Infelizmente vc não pode!");
			}

		}

	}

}
