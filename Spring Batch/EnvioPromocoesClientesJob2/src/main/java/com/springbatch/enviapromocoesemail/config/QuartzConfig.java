package com.springbatch.enviapromocoesemail.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.enviapromocoesemail.job.EnvioPromocoesClientesScheduleJob;

@Configuration
public class QuartzConfig {

	@Bean
	public JobDetail jobDetail() {
		return JobBuilder
				.newJob(EnvioPromocoesClientesScheduleJob.class)
				.storeDurably()
				.build();
	}
	
	@Bean
	public Trigger jobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = 
				SimpleScheduleBuilder
				.simpleSchedule()
				.withIntervalInSeconds(60)
				.withRepeatCount(2);
		return TriggerBuilder
				.newTrigger()
				.forJob(jobDetail())
				.withSchedule(scheduleBuilder)
				.build();
	}
}
