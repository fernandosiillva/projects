package br.com.alura.loja.http;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpAdapter implements HttpAdapter {

	@Override
	public void post(String url, Map<String, Object> dados) {
		try {
			URL urlApi = new URL(url);
			URLConnection connection = urlApi.openConnection();
			connection.connect();
		} catch (Exception e) {
			throw new RuntimeException("erro ao enviar dados!", e);
		}
	}

}
