package RequisicaoWeb;

public class RespostaXML implements Resposta {

	private Resposta resposta;	

	public RespostaXML(Resposta proximaResposta) {
		this.resposta = proximaResposta;
	}
	
	@Override
	public void responde(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato() == Formato.XML) {
			System.out.println("<conta><titular>" + conta.getNomeTitular() + "</titular>" + "<saldo>" + conta.getSaldo()
					+ "</saldo>" + "</conta>");
		} else {
			resposta.responde(requisicao, conta);
		}
	}
}
