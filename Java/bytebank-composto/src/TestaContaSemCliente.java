
public class TestaContaSemCliente {

	public static void main(String[] args) {
		
		Conta contaDaAngelica = new Conta();
		
		contaDaAngelica.titular = new Cliente();
		
		contaDaAngelica.titular.nome = "Angelica";
		
		System.out.println(contaDaAngelica.titular.nome);
	}

}
