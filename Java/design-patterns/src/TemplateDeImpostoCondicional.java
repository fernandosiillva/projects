
public abstract class TemplateDeImpostoCondicional extends Imposto{

	@Override
	public double calcula(Orcamento orcamento) {
		if (deveUsarMaximaTaxacao(orcamento)) {
			return maximaTaxacao(orcamento) + calculadoraDoOutroImposto(orcamento);
		} else {
			return minimaTaxacao(orcamento) + calculadoraDoOutroImposto(orcamento);
		}
	}

	public abstract double minimaTaxacao(Orcamento orcamento);

	public abstract double maximaTaxacao(Orcamento orcamento);

	public abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);

	
}
