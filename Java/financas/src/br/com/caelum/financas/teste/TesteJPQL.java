package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManager entityManager = new JPAUtil().getEntityManager();		
		entityManager.getTransaction().begin();		
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta";
		Query createQuery = entityManager.createQuery(jpql);
		createQuery.setParameter("pConta", conta);
		
		List<Movimentacao> resultList = createQuery.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println("Desc: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getConta().getId());
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
