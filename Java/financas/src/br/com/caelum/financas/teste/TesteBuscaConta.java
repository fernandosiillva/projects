package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {

		EntityManager entityManager = new JPAUtil().getEntityManager();		
		entityManager.getTransaction().begin();		
		Conta contaBanco = entityManager.find(Conta.class, 1);		
		contaBanco.setTitular("João");		
		System.out.println(contaBanco.getTitular());		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		EntityManager entityManager2 = new JPAUtil().getEntityManager();		
		entityManager2.getTransaction().begin();			
		entityManager2.merge(contaBanco);
		contaBanco.setTitular("Leo");	
		entityManager2.getTransaction().commit();
		entityManager2.close();
	}

}
