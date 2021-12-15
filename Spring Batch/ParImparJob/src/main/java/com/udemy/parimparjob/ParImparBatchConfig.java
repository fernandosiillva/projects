package com.udemy.parimparjob;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ParImparBatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job imprimeParImparJob() {
		return jobBuilderFactory.get("imprimeParImparJob").start(imprimeParImparStep())
				.incrementer(new RunIdIncrementer()).build();
	}

	public Step imprimeParImparStep() {
		return stepBuilderFactory
				.get("imprimeParImparStep")
				.<Integer, String>chunk(10)
				.reader(contaAteDezReader())
				.processor(parOuImparProcessor())
				.writer(imprimeWrite())
				.build();
	}

	private ItemWriter<String> imprimeWrite() {
		return itens -> itens.forEach(System.out::println);
	}

	private FunctionItemProcessor<Integer, String> parOuImparProcessor() {
		return new FunctionItemProcessor<>(item -> item % 2 == 0 ? String.format("Item %s é Par", item) : String.format("Item %s é Impar", item));
	}

	public IteratorItemReader<Integer> contaAteDezReader() {
		List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		return new IteratorItemReader<Integer>(lista.iterator());
	}
}
