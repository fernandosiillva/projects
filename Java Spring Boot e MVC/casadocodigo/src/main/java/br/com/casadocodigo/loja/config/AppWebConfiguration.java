package br.com.casadocodigo.loja.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.cache.CacheBuilder;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.CarrinhoCompras;

//Informo ao Spring quais as classes serão scaneadas por ele.
@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class, FileSaver.class, CarrinhoCompras.class})
@EnableCaching
public class AppWebConfiguration extends WebMvcConfigurerAdapter{

//	Informo ao Spring onde estão salvas as minhas views, definindo também seu caminho com o prefixo e seu sufixo.
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposedContextBeanNames("carrinhoCompras");
		return resolver;
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource 
			= new ReloadableResourceBundleMessageSource();
		
		bundleMessageSource.setBasename("/WEB-INF/messages");
		bundleMessageSource.setDefaultEncoding("UTF-8");
		bundleMessageSource.setCacheSeconds(1);
		
		return bundleMessageSource;
	}
	
	@Bean
	public FormattingConversionService mvcConversionService() {
		
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar dateFormatterRegistrar = new DateFormatterRegistrar();
		dateFormatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		dateFormatterRegistrar.registerFormatters(conversionService);
		
		return conversionService;
	}
	
	/* MultipartResolver se refere a um resolvedor de dados multimídia. Quando temos texto e arquivos por exemplo. 
	 * Os arquivos podem ser: imagem, PDF e outros. Este objeto é que identifica cada um dos recursos enviados e 
	 * nos fornece uma forma mais simples de manipulá-los.*/
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public CacheManager cacheManager() {
		CacheBuilder<Object, Object> builder = CacheBuilder
				.newBuilder()
				.maximumSize(100)
				.expireAfterAccess(5, TimeUnit.MINUTES);
		GuavaCacheManager manager =  new GuavaCacheManager();
		manager.setCacheBuilder(builder);
		return manager;
	}
	
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		
		List<ViewResolver> viewResolvers = new ArrayList<>();
		viewResolvers.add(internalResourceViewResolver());
		viewResolvers.add(new JsonViewResolver());
		
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(viewResolvers);
		resolver.setContentNegotiationManager(manager);
		
		return resolver;
	}
}
