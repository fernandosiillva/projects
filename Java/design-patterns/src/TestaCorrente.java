public class TestaCorrente {

	public static void main(String[] itens) {

		DescontoPorCincoItens descontoPorCincoItens = new DescontoPorCincoItens();
		DescontoPorMaisDeQuinhentosReais descontoPorMaisDeQuinhentosReais = new DescontoPorMaisDeQuinhentosReais();
		DescontoPorVendaCasada descontoPorVendaCasada = new DescontoPorVendaCasada();
		SemDesconto semDesconto = new SemDesconto();

		descontoPorCincoItens.setProximoDesconto(descontoPorMaisDeQuinhentosReais);
		descontoPorMaisDeQuinhentosReais.setProximoDesconto(descontoPorVendaCasada);
		descontoPorVendaCasada.setProximoDesconto(semDesconto);
		
		Item caneta = new Item("CANETA", 50.0);
		Item lapis = new Item("LAPIS", 20.0);
		Item borracha = new Item("BORRACHA", 15.0);
		
		Orcamento orcamento = new Orcamento(500.0);
		orcamento.adicionaItem(lapis);
		orcamento.adicionaItem(caneta);
		orcamento.adicionaItem(borracha);
		
		double desconta = descontoPorCincoItens.desconta(orcamento);
		System.out.println("Desconto: " + desconta);
	}

}
