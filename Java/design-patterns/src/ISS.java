
public class ISS extends Imposto{

	public ISS(Imposto imposto) {
		super(imposto);
	}
	
	public ISS() {}
	
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + calculadoraDoOutroImposto(orcamento);
	}	
}
