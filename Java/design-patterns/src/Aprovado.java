
public class Aprovado implements EstadoDeUmOrcamento{

	public void aplicaDescontoExtra(Orcamento orcamento) {
		orcamento.valor -= orcamento.valor * 0.02; 
	}

	@Override
	public void aprovado(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� est� aprovado!");
	}

	@Override
	public void reprovado(Orcamento orcamento) {
		throw new RuntimeException("Or�amento aprovados n�o podem ser reprovados");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		orcamento.estadoAtual =  new Finalizado();
	}
}
