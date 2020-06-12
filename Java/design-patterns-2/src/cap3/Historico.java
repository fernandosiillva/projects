package cap3;

import java.util.ArrayList;
import java.util.List;

public class Historico {

	private List<Estado> estadosSalvos = new ArrayList<Estado>();
	
	public Estado pega (int index) {
		return estadosSalvos.get(index);
	}
	
	public void adiciona(Estado estado) {
		estadosSalvos.add(estado);
	}
}
