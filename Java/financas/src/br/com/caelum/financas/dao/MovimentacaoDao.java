package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {

	private EntityManager entityManager;	
	
	public MovimentacaoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Double> getMediaPorDiaETipo(TipoMovimentacao saida, Conta conta) {

		String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :mTipo group by m.data";
		TypedQuery<Double> createQuery = entityManager.createQuery(jpql, Double.class);
		createQuery.setParameter("pConta", conta);
		createQuery.setParameter("mTipo", TipoMovimentacao.SAIDA);
				
		return createQuery.getResultList();
	}
}
