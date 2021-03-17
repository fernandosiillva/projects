package com.springbatch.jdbcpagingreader.reader;

import com.springbatch.jdbcpagingreader.dominio.Cliente;
import com.springbatch.jdbcpagingreader.dominio.Conta;
import com.springbatch.jdbcpagingreader.dominio.TipoConta;

public class TipoPrata extends TipoContaAbstract{

	public TipoPrata(TipoContaAbstract proximo) {
		super(proximo);
	}

	@Override
	protected Conta novaContaCriada(Cliente cliente) {
		return new Conta(TipoConta.PRATA, 500.00, cliente.getEmail());
	}

	@Override
	protected boolean clienteValidate(Cliente cliente) {
		if (cliente.getFaixaSalarial() <= 3000) {
			return true;
		} else {
			return false;
		}
	}

}
