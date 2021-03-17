package com.springbatch.jdbcpagingreader.reader;

import com.springbatch.jdbcpagingreader.dominio.Cliente;
import com.springbatch.jdbcpagingreader.dominio.Conta;

public abstract class TipoContaAbstract {

	protected TipoContaAbstract proximo;

	public TipoContaAbstract(TipoContaAbstract proximo) {
		this.proximo = proximo;
	}
	
	public Conta novaConta(Cliente cliente) {
		if (clienteValidate(cliente)) {
			return novaContaCriada(cliente);
		}
		
		return proximo.novaConta(cliente);
	}

	protected abstract Conta novaContaCriada(Cliente cliente);

	protected abstract boolean clienteValidate(Cliente cliente);
}
