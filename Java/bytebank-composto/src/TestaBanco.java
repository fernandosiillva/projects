
public class TestaBanco {

	public static void main(String[] args) {
		
		Cliente fernando = new Cliente();
		
		fernando.nome = "Fernando Bezerra";
		fernando.cpf = "105.124.634-25";
		fernando.profissao = "Desenvolvedor";
		
		Conta contaDoFernando = new Conta();
		
		contaDoFernando.deposita(100);
		
		contaDoFernando.titular = fernando;
		
		System.out.println(contaDoFernando.titular.nome);

	}

}
