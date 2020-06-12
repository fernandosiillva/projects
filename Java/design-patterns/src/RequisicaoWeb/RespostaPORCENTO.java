package RequisicaoWeb;

public class RespostaPORCENTO implements Resposta {

	private Resposta resposta;	
	
	public RespostaPORCENTO(Resposta proximaResposta) {
		super();
		this.resposta = proximaResposta;
	}

	@Override
	public void responde(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato() == Formato.PORCENTO) {
			System.out.println(conta.getNomeTitular() + "%" + conta.getSaldo());
		} else {
			resposta.responde(requisicao, conta);
		}
	}
}
