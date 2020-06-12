
public class ICMS extends Imposto{

	public ICMS() {}
	
	public ICMS(Imposto imposto) {
		super(imposto);
	}
	
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.1 + calculadoraDoOutroImposto(orcamento);
	}
}
