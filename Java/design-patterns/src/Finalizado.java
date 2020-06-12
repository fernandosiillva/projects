
public class Finalizado implements EstadoDeUmOrcamento{

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos finalizados não recebem desconto extra");
	}

	@Override
	public void aprovado(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos já finalizado");
	}

	@Override
	public void reprovado(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos já finalizado");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos já finalizado");
	}

}
