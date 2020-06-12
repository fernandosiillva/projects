package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(2);
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");
						
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Viagem a Recife");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("100.0"));
		movimentacao.setCategoria(Arrays.asList(categoria, categoria2));
		
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem a Portugal");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("5600.0"));
		movimentacao2.setCategoria(Arrays.asList(categoria, categoria2));
		
		movimentacao2.setConta(conta);
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(categoria);
		entityManager.persist(categoria2);
		
		entityManager.persist(movimentacao);
		entityManager.persist(movimentacao2);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
