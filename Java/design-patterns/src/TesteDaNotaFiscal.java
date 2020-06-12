
public class TesteDaNotaFiscal {

	public static void main(String[] args) {
		
		CriadorDeNotaFiscal criador = new CriadorDeNotaFiscal();
		criador.paraEmpresa("FACEBOOK")
		.comCnpj("126.125.454/0001-12")
		.comItem(new ItemDaNota("item 1", 200.0))
		.comItem(new ItemDaNota("item 2", 300.0))
		.comItem(new ItemDaNota("item 3", 400.0))
		.comObservacoes("observacoes")
		.comData();
		NotaFiscal notaFiscal = criador.constroiNF();
		
		System.out.println(notaFiscal.getValorBruto());
	}
}
