package RequisicaoWeb;

public class SemResposta implements Resposta {

	@Override
	public void responde(Requisicao requisicao, Conta conta) {
		System.out.println("Sem resposta!");
	}
}
