package RequisicaoWeb;

public class RespostaCSV implements Resposta {

	private Resposta resposta;	
	
	public RespostaCSV(Resposta proximaResposta) {
		this.resposta = proximaResposta;
	}

	@Override
	public void responde(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato() == Formato.CSV) {
			System.out.println(conta.getNomeTitular() + "-" + conta.getSaldo());
		} else {
			resposta.responde(requisicao, conta);
		}
	}
}
