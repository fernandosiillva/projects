package cap6;

import java.io.InputStream;
import java.net.URL;

public class GoogleMaps implements Mapa{

	@Override
	public String devolveMapa(String rua) {		
		try {
			String googleMaps = "http://maps.google.com.br/maps?q=rua+vergueiro";
			URL url = new URL(googleMaps);
			InputStream openStream = url.openStream();
			return "mapa";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
