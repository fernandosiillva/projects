package cap7;

public class PagaPedido implements Comando{

	private Pedido pedido;

	public PagaPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public void executa() {
		System.out.println("Pagando pedido do " + pedido.getCliente());
		pedido.paga();
	}

}
