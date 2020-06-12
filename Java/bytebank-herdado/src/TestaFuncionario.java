
public class TestaFuncionario {

	public static void main(String[] args) {
				
		Gerente fernando = new Gerente();
		
		fernando.setNome("Fernando Bezerra");
		
		fernando.setCpf("123456789");
		
		fernando.setSalario(3000.00);
		
		System.out.println("nome: " + fernando.getNome() + "\nbonificacao: " + fernando.getBonificacao());

	}

}
