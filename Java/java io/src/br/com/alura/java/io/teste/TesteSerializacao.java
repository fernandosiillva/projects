package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacao {

	public static void main(String[] args) throws Exception {

//		String nome = "Fernando Bezerra";
//		
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
//		oos.writeObject(nome);
//		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
		
		String nome = (String) ois.readObject();
		
		System.out.println(nome);
	}

}
