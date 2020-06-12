
public class TestaCondicionais2 {

	public static void main(String[] args) {

		System.out.println("testentando condicionais");

		int idade = 18;
		int quantidadePessoas = 3;
		boolean acompanhado = quantidadePessoas >= 5;

		System.out.println(acompanhado);
		if (idade >= 18 && acompanhado) {
			System.out.println("Seja bem vindo");
		} else {
			System.out.println("Infelizmente vc não pode!");

		}
	}

}
