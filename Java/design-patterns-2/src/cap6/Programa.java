package cap6;

public class Programa {

	public static void main(String[] args) throws Exception {
		
//		regra de negocio
		
		Mapa googleMaps = new GoogleMaps();
		googleMaps.devolveMapa("rua rio amazonas");
	}
}
