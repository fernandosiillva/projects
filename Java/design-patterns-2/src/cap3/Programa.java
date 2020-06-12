package cap3;

import java.util.Calendar;

public class Programa {

	public static void main(String[] args) {
		Historico historico = new Historico();
		
		Contrato contrato = new Contrato(Calendar.getInstance(), "Fernando", TipoContrato.NOVO);
		historico.adiciona(contrato.salvaEstado());
		
		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());
		
		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());
		
		Estado estadoAnterior = historico.pega(0);
		System.out.println(estadoAnterior.getEstado().getTipo());
	}
}
