package calculadoraDeSalario;
public class Funcionario {
	private double salario = 0;
	private Cargo cargo;		
	Funcionario(double salario, Cargo cargo){
		this.salario = salario;
		this.cargo = cargo;
	}	
	public double getSalario() {
		return this.salario;
	}	
	public Cargo getCargo() {
		return this.cargo;
	}
}
