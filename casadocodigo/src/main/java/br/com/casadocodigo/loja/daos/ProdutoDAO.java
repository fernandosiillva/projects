package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;

//Informo ao spring que essa classe será um repositorio de uma entidade no nosso caso da entidade produto.
//Agora precisamos definir que o nosso ProdutoDAO é uma classe Transancional e fazemos isso através da anotação @Transactional do pacote org.springframework.transaction.annotation.Transactional.
@Repository
@Transactional
public class ProdutoDAO {

//	Instancio o entityManager como um atributo da classe para manipular a entidade em questão que no nosso caso é produto.
	@PersistenceContext
	private EntityManager manager;
	
//	Uso o atributo para persistir no banco a entidade produto.
	public void gravar(Produto produto) {
		manager.persist(produto);
	}
	
	public List<Produto> listar(){
		return manager.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	public Produto find(int id) {
//		return manager.find(Produto.class, id);
		return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id", Produto.class)
				.setParameter("id", id).getSingleResult();
	}
}
