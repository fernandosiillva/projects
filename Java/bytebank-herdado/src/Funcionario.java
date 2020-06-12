//n�o pode instanciar essa classe pois � abstrata
public abstract class Funcionario {
	
	private String nome;
	private String cpf;
	private double salario;//protected as informa��es aqui contidas ser�o p�blicas apenas para si e para os filhos
	
	public Funcionario() {
		
	}
	
	//metodo sem corpo abstrato
	public abstract double getBonificacao();	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	

}
