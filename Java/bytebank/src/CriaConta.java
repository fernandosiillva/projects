
public class CriaConta {

	public static void main(String[] args) {
		
		//primeira Conta
		
		Conta primeiraConta = new Conta();
		
		primeiraConta.saldo = 200;
		
		System.out.println(primeiraConta.saldo);
		
		primeiraConta.saldo += 100;
		
		System.out.println(primeiraConta.saldo);
		
		//segunda Conta
		
		Conta segundaConta = new Conta();
		
		segundaConta.saldo = 50;
		
		System.out.println(segundaConta.saldo);
	}

}
