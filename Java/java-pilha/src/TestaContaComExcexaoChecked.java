
public class TestaContaComExcexaoChecked {

	public static void main(String[] args) {
		Conta c = new Conta();
		try {
			c.deposita();
		} catch (MinhaExcecao e) {
			System.out.println("tratamento ..");
		}
		
	}

}
