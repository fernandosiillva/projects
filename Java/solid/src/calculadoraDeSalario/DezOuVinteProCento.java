package calculadoraDeSalario;

public class DezOuVinteProCento implements RegraDeCalculo {

	@Override
	public double calcula(Funcionario funcionario) {

		if (funcionario.getSalario() > 3000.0) {
			return funcionario.getSalario() * 0.8;
		} else {
			return funcionario.getSalario() * 0.9;
		}
	}

}
