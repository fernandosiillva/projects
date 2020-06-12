
public class TesteGerente {

	public static void main(String[] args) {
		
		Gerente g1 = new Gerente();
		
		Autenticavel referencia = new Gerente();
		
		g1.setNome("Fernando");
		g1.setCpf("11232456789");
		g1.setSalario(5000.0);
		
		System.out.println(g1.getNome());
		
		g1.setSenha(222);		
		
		boolean autentica = g1.autentica(222);
		
		System.out.println(autentica);
		
		System.out.println(g1.getBonificacao());
	}

}
