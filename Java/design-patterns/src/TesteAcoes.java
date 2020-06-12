
public class TesteAcoes {

	public static void main(String[] args) {
		CriadorDeNotaFiscal criadorDeNotaFiscal = new CriadorDeNotaFiscal();

		criadorDeNotaFiscal.adiconaAcao(new enviadorDeEmail());
		criadorDeNotaFiscal.adiconaAcao(new EnviaPorSms());
		criadorDeNotaFiscal.adiconaAcao(new NotaFiscalDao());
		criadorDeNotaFiscal.adiconaAcao(new Impressora());

		NotaFiscal nf = criadorDeNotaFiscal.paraEmpresa("FACE").comCnpj("123").comItem(new ItemDaNota("nome", 100.0))
				.comObservacoes("OBS").comData().constroiNF();
		System.out.println(nf.getValorBruto());
	}
}
