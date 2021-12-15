package com.springbatch.arquivomultiplosformatos.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.arquivomultiplosformatos.dominio.Cliente;

@Configuration
public class LeituraArquivoMultiplosFormatosStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public Step leituraArquivoMultiplosFormatosStep(
			MultiResourceItemReader<Cliente> multiplosArquivoMultiplosFormatosReader,
			ItemWriter leituraArquivoMultiplosFormatosItemWriter) {
		return stepBuilderFactory
				.get("leituraArquivoMultiplosFormatosStep")
				.chunk(1)
				.reader(multiplosArquivoMultiplosFormatosReader)
				.writer(leituraArquivoMultiplosFormatosItemWriter)
				.build();
	}
}
