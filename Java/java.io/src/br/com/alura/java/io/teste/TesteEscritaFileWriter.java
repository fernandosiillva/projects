package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteEscritaFileWriter {

	public static void main(String[] args) throws IOException {

//		OutputStream fos = new FileOutputStream("lorem2.txt");
//		Writer otw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(otw);
				
		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");		
		bw.newLine();
		bw.newLine();
		bw.write("Teste linha 2.");
		
		bw.close();
	}

}
