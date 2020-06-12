
public interface EstadoDeUmOrcamento {
	void aplicaDescontoExtra(Orcamento orcamento);
	
	void aprovado(Orcamento orcamento);
	void reprovado(Orcamento orcamento);
	void finaliza(Orcamento orcamento);
	
}
