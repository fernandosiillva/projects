package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(1);
		conta.setTitular("Angelica");
		conta.setBanco("Caixa");
		conta.setNumero("10300");
		conta.setAgencia("050");
		
		EntityManager jpaUtil = new JPAUtil().getEntityManager();
		
		jpaUtil.getTransaction().begin();
		
		conta = jpaUtil.find(Conta.class, 1);
		
		jpaUtil.remove(conta);
		
		jpaUtil.getTransaction().commit();
		
		jpaUtil.close();		
	}

}
