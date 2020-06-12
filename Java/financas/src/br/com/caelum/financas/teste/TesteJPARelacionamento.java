package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setAgencia("038s2");
		conta.setBanco("Brasil");
		conta.setNumero("2589");
		conta.setTitular("Everton");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Shopping");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("300.0"));
		movimentacao.setConta(conta);
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(conta);
		entityManager.persist(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
