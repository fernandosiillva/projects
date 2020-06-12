package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(2);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Fernando");
		cliente.setEndereco("Rua Amazonas, 254");
		cliente.setProfissao("Developer");
				
		//Vinculando a conta ao cliente
		cliente.setConta(conta);
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(cliente);
		
		entityManager.getTransaction().commit();
		
	}

}
