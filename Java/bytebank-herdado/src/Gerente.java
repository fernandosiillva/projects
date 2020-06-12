////Gerente � um Funcionario, Gerente herda da classe Funcionario
public class Gerente extends Funcionario implements Autenticavel{
	
	private AutenticacaoUtil autenticador;

	public Gerente() {
		this.autenticador = new AutenticacaoUtil();
	}

	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}
	
	public double getBonificacao() {
		System.out.println("chamando o metodo de bonifica��o do gerente");
		return super.getSalario();//o super vem da classe m�e
	}

	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}
	
}
