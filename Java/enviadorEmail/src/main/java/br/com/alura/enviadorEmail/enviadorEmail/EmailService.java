package br.com.alura.enviadorEmail.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void enviar(String nome, String emailConvidado) {
        
        try {
        	SimpleEmail email = new SimpleEmail();
    		email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("fernandosiillva01@gmail.com", "piter159753852"));
            email.setSSLOnConnect(true);
            
			email.setFrom("fernandosiillva01@gmail.com");			
			email.setSubject("Você foi convidado pelo ListaVIP");
	        email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
	        email.addTo(emailConvidado);
	        email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
