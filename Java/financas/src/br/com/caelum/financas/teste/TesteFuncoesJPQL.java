package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {

		EntityManager entityManager = new JPAUtil().getEntityManager();		
		entityManager.getTransaction().begin();		
		
		Conta conta = new Conta();
		conta.setId(2);
		
		TypedQuery<Double> typedQuery = entityManager.createNamedQuery("MediasPorDiaETipo", Double.class);
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("mTipo", TipoMovimentacao.SAIDA);

		List<Double> resultList = typedQuery.getResultList();
		
		System.out.println(resultList);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
