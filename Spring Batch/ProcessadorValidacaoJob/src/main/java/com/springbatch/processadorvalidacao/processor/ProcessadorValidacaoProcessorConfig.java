package com.springbatch.processadorvalidacao.processor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.processadorvalidacao.dominio.Cliente;

@Configuration
public class ProcessadorValidacaoProcessorConfig {
	
	private Set<String> emails = new HashSet<String>();
	
	@Bean
	public ItemProcessor<Cliente, Cliente> procesadorValidacaoProcessor() throws Exception {
		return new CompositeItemProcessorBuilder<Cliente, Cliente>()
				.delegates(beanValidatingProcessor(), validatingItemProcessor())
				.build();
				
	}

	public ValidatingItemProcessor<Cliente> validatingItemProcessor() {
		ValidatingItemProcessor<Cliente> processor = new ValidatingItemProcessor<>();
		processor.setValidator(validator());
		processor.setFilter(true);
		return processor;
	}

	public BeanValidatingItemProcessor<Cliente> beanValidatingProcessor() throws Exception {
		BeanValidatingItemProcessor<Cliente> processor = new BeanValidatingItemProcessor<>();
		processor.setFilter(true);
		processor.afterPropertiesSet();
		return processor;
	}

	private Validator<Cliente> validator() {
		return new Validator<Cliente>() {
			
			@Override
			public void validate(Cliente cliente) throws ValidationException {
				if (emails.contains(cliente.getEmail())) {
					throw new ValidationException(String.format("O cliente %s já foi processado",cliente.getNome()));
				}
				emails.add(cliente.getEmail());
			}
		};
	}
}
