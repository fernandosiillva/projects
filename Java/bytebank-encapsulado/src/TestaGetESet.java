
public class TestaGetESet {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setNumero(1337);
		System.out.println(conta.getNumero());
		
		Cliente fernando = new Cliente();
		
		conta.setTitular(fernando);
		
		fernando.setNome("Fernando Bezerra");
		
		System.out.println(conta.getTitular().getNome());
	}

}
