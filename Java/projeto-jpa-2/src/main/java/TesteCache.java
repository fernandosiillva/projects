import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.JpaConfigurator;
import br.com.caelum.model.Produto;

public class TesteCache {

	public static void main(String[] args) {

		ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JpaConfigurator.class);
		
		EntityManagerFactory bean = annotationConfigApplicationContext.getBean(EntityManagerFactory.class);
		EntityManager createEntityManager = bean.createEntityManager();
		
		Produto produto = createEntityManager.find(Produto.class, 1);
		System.out.println("Nome: " + produto.getNome());
		
		Produto outroProduto = createEntityManager.find(Produto.class, 1);
        System.out.println("Nome: " + outroProduto.getNome());
	}

}
