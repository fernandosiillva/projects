package br.com.casadocodigo.loja.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//a anotação @EnableTransactionManagement. Assim o Spring ativa o gerenciamento de transações e já reconhece o TransactionManager.
@EnableTransactionManagement
public class JPAConfiguration {

	@Bean
	private LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
//		Informo ao Spring sobre o entityManager para assim depois de instancialo configurar qual o banco e suas propriedades.
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();		
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();		
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		
//		O driverManagerDataSource serve para informa qual o banco e suas configurações.
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("12345");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo?useTimezone=true&serverTimezone=UTC");
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
//		Informo ao entityManager qual as informações do banco serão configuradas para o spring.
		factoryBean.setDataSource(driverManagerDataSource);
		
//		Instanciando o properties para configurações opcionais do banco.
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");//Qual o dialeto do banco (Linguagen do MySQL).
		properties.setProperty("hibernate.show_sql", "true");//Posso ver quais estruturas de sql são realizadas no console.
		properties.setProperty("hibernate.hbm2ddl.auto", "update");//O tipo de manuseio do banco, update faz com que o Spring tome todas as precauções sobre as entidades, mantendo-as atualizadas.
		
//		Informo ao entityManer qual as propriedades extras que quero trabalhar.
		factoryBean.setJpaProperties(properties);
		
//		Informo ao entityManager o caminho das entidades que serão persistidas no banco.
		factoryBean.setPackagesToScan("br.com.casadocodigo.loja.models");
		
		return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
