
public abstract class Imposto {

	protected Imposto imposto;
	
	public Imposto(Imposto outroImposto) {
		this.imposto = outroImposto;
	}
	
	public Imposto() {}
	
	public abstract double calcula(Orcamento orcamento);
	
	protected double calculadoraDoOutroImposto(Orcamento orcamento) {
		if (imposto == null) return 0;
		return imposto.calcula(orcamento);
	}
}
