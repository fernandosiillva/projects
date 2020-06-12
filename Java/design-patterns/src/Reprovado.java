
public class Reprovado implements EstadoDeUmOrcamento{

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Or�amento reprovados n�o recebem desconto extra!");
	}

	@Override
	public void aprovado(Orcamento orcamento) {
		throw new RuntimeException("Or�amento reprovados n�o recebem desconto extra");
	}

	@Override
	public void reprovado(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� est� reprovado");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual =  new Finalizado();
	}

}
