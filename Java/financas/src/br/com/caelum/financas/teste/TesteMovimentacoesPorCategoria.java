package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {

	public static void main(String[] args) {

		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		
		Query createQuery = entityManager.createQuery(jpql);
		createQuery.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultList = createQuery.getResultList();
		
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Desc: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getConta().getId());
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
