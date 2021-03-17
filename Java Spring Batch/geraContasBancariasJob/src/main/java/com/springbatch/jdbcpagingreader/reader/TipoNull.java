package com.springbatch.jdbcpagingreader.reader;

import com.springbatch.jdbcpagingreader.dominio.Cliente;
import com.springbatch.jdbcpagingreader.dominio.Conta;

public class TipoNull extends TipoContaAbstract{

	public TipoNull() {
		super(null);
	}

	@Override
	protected Conta novaContaCriada(Cliente cliente) {
		return null;
	}

	@Override
	protected boolean clienteValidate(Cliente cliente) {
		return true;
	}

}
