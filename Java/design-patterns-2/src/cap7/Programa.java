package cap7;

public class Programa {

	public static void main(String[] args) {
		Pedido pedido = new Pedido("Fernando", 100.0);
		Pedido pedido2 = new Pedido("Angelica", 200.0);
		
		FilaDeTrabalho filaDeTrabalho = new FilaDeTrabalho();
		
		filaDeTrabalho.adiciona(new PagaPedido(pedido));
		filaDeTrabalho.adiciona(new PagaPedido(pedido2));
		filaDeTrabalho.adiciona(new ConcluiPedido(pedido));
		
		filaDeTrabalho.processa();
	}
}
