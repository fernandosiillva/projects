package com.springbatch.jdbcpagingreader.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.jdbcpagingreader.dominio.Cliente;

@Configuration
public class JdbcPagingReaderStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step contasBancariasStep(ItemReader<Cliente> contasBancariasReader,ItemProcessor itemProcessor, ItemWriter contasBancariasWriter) {
		return stepBuilderFactory
				.get("contasBancariasStep")
				.chunk(1)
				.reader(contasBancariasReader)
				.processor(itemProcessor)
				.writer(contasBancariasWriter)
				.build();
	}
}
