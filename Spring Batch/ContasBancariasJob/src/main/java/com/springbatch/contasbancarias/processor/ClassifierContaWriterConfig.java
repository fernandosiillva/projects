package com.springbatch.contasbancarias.processor;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.contasbancarias.dominio.Conta;

@Configuration
public class ClassifierContaWriterConfig {

	@Bean
	public ClassifierCompositeItemWriter<Conta> compositeItemWriter(
			@Qualifier("clienteInvalidoWriter") FlatFileItemWriter<Conta> clienteInvalidoWriter,
			CompositeItemWriter<Conta> clienteValidoWrite){
		return new ClassifierCompositeItemWriterBuilder<Conta>()
				.classifier(classifier(clienteInvalidoWriter, clienteValidoWrite))
				.build();
	}

	@SuppressWarnings("serial")
	private Classifier<Conta, ItemWriter<? super Conta>> classifier(FlatFileItemWriter<Conta> clienteInvalidoWriter,
			CompositeItemWriter<Conta> clienteValidoWrite) {
		return new Classifier<Conta, ItemWriter<? super Conta>>() {

			@Override
			public ItemWriter<? super Conta> classify(Conta conta) {
				if (conta.getTipo() != null) {
					return clienteValidoWrite;
				} else {
					return clienteInvalidoWriter;

				}
			}
			
		};
	}
}
