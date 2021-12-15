package com.udemy.primeiroprojetospringbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepSpringBatchConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step imprimeStep(Tasklet imprimeOlaTasklet) {
		// TODO Auto-generated method stub
		return stepBuilderFactory
				.get("imprimeStep")
				.tasklet(imprimeOlaTasklet)
				.build();
	}
}
