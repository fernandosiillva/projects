import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CriadorDeNotaFiscal {

	private String razaoSocial;
	private String cnpj;
	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	private double valorBruto;
	private double impostos;
	private String comObservacoes;
	private Calendar data;
	private List<AcaoAposGerarNota> todasAcoesASeremExecutadas;

	public CriadorDeNotaFiscal() {
		this.todasAcoesASeremExecutadas = new ArrayList<AcaoAposGerarNota>();
	}
	
	public void adiconaAcao(AcaoAposGerarNota acao) {
		this.todasAcoesASeremExecutadas.add(acao);
	}
	
	public CriadorDeNotaFiscal paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public CriadorDeNotaFiscal comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public CriadorDeNotaFiscal comItem(ItemDaNota item) {
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}

	public CriadorDeNotaFiscal comObservacoes(String observacoes) {
		this.comObservacoes = observacoes;
		return this;
	}

	public CriadorDeNotaFiscal comData() {
		this.data = Calendar.getInstance();
		return this;
	}

	public NotaFiscal constroiNF() {

		NotaFiscal nf = new NotaFiscal(razaoSocial, cnpj, data, valorBruto, impostos, todosItens, comObservacoes);
		for (AcaoAposGerarNota acaoAposGerarNota : todasAcoesASeremExecutadas) {
			acaoAposGerarNota.executa(nf);
		}
		return nf;
	}

}
