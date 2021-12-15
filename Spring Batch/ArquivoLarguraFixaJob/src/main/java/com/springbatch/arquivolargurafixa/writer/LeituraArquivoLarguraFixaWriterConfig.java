package com.springbatch.arquivolargurafixa.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.springbatch.arquivolargurafixa.dominio.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {
	
	@StepScope
	@Bean
	public FlatFileItemWriter<Cliente> escritaArquivoLarguraFixaWriter(
			@Value("#{jobParameters['arquivoClientesSaida']}") Resource arquivoClientesSaida) {
		return new FlatFileItemWriterBuilder<Cliente>()
				.name("escritaArquivoLarguraFixaWriter")
				.resource(arquivoClientesSaida)
				.formatted()
				.format("%-9s %-9s %-2s %-19s")
				.names("nome", "sobrenome", "idade", "email")
				.build();
	}
	
//	@Bean
//	public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter() {
//		return items -> items.forEach(System.out::println);
//		return items -> {
//			for (Cliente cliente : items) {
//				if (cliente.getNome().equals("Maria")) {
//					throw new Exception();
//				} else {
//					System.out.println(cliente);
//				}
//			}
//		};
//	}
}
