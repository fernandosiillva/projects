package cap4;

public class Subtracao implements Expressao {

	private Expressao direita;
	private Expressao esquerda;

	public Subtracao(Expressao esquerda, Expressao direita) {
		this.direita = direita;
		this.esquerda = esquerda;
	}

	@Override
	public int avalia() {
		int valorDaEsquerda = esquerda.avalia();
		int valorDaDireita = direita.avalia();
		return valorDaEsquerda - valorDaDireita;
	}
	
	public Expressao getEsquerda() {
		return esquerda;
	}
	
	public Expressao getDireita() {
		return direita;
	}

	@Override
	public void aceita(Impressora impressora) {
		impressora.visitaSubtracao(this);
	}
}
