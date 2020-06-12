package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
        
        Query createQuery = em.createQuery(jpql);
        
		List<Conta> resultList = createQuery.getResultList();
		
		for (Conta conta : resultList) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentações: ");
			System.out.println(conta.getMoviventacoes());
		}
		
	}

}
