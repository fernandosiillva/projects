
public class EmAprovacao implements EstadoDeUmOrcamento{

	public void aplicaDescontoExtra(Orcamento orcamento) {
		orcamento.valor -= orcamento.valor * 0.05;
	}

	@Override
	public void aprovado(Orcamento orcamento) {
		orcamento.estadoAtual = new Aprovado();
	}

	@Override
	public void reprovado(Orcamento orcamento) {
		orcamento.estadoAtual = new Reprovado();
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orçamento em aprovação não podem ir direto para finalizado!");
	}
}
