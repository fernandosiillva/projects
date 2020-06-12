package RequisicaoWeb;

public class TestaRequisicao {

	public static void main(String[] args) {
		
		Conta contaFernando = new Conta("Fernando", 100.0);
						
		Requisicao requisicao = new Requisicao(Formato.CSV);
		
		SemResposta semResposta = new SemResposta();
		
		RespostaPORCENTO respostaPORCENTO = new RespostaPORCENTO(semResposta);
		
		RespostaCSV respostaCSV = new RespostaCSV(respostaPORCENTO);		
		
		respostaCSV.responde(requisicao, contaFernando);
	}

}
