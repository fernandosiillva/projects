package br.com.bytebank.banco.test.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteDeserializacao {

	public static void main(String[] args) throws Exception {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cc.bin"));
		
		ContaCorrente cc = (ContaCorrente) ois.readObject();
		ois.close();
		System.out.println(cc.getSaldo());
		//System.out.println(cc.getTitular().getNome());
	}

}
