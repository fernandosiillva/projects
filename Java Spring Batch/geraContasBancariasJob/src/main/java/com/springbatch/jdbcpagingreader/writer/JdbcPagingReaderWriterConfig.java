package com.springbatch.jdbcpagingreader.writer;

import java.util.function.Consumer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.jdbcpagingreader.dominio.Conta;
import com.springbatch.jdbcpagingreader.repository.ContaRepository;


@Configuration
public class JdbcPagingReaderWriterConfig {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ItemWriter contasBancariasWriter() {
		return conta  -> conta.forEach(new Consumer<Conta>() {

			@Override
			public void accept(Conta conta) {
				contaRepository.save(conta);
			}
		});
		
	}
}
