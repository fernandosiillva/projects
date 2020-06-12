package cap4;

public class Numero implements Expressao{

	private int numero;

	public Numero(int numero) {
		this.numero = numero;
	}

	@Override
	public int avalia() {
		return numero;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public void aceita(Impressora impressora) {
		impressora.visitaNumero(this);
	}
}
