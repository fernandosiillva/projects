
public class TestaMetodos {

	public static void main(String[] args) {
		
		Conta primeiraConta = new Conta();
		
		primeiraConta.deposita(50);
		System.out.println(primeiraConta.saldo);
		
		primeiraConta.saca(20);
		System.out.println(primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.deposita(1000);
		
		if(segundaConta.transfere(300, primeiraConta)) {
			System.out.println();
		}
		System.out.println(segundaConta.saldo);
		System.out.println(primeiraConta.saldo);
	}	

}
