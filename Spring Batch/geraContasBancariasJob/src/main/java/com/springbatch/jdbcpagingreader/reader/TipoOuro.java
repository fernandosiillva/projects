package com.springbatch.jdbcpagingreader.reader;

import com.springbatch.jdbcpagingreader.dominio.Cliente;
import com.springbatch.jdbcpagingreader.dominio.Conta;
import com.springbatch.jdbcpagingreader.dominio.TipoConta;

public class TipoOuro extends TipoContaAbstract{

	public TipoOuro(TipoContaAbstract proximo) {
		super(proximo);
	}

	@Override
	protected Conta novaContaCriada(Cliente cliente) {
		return new Conta(TipoConta.OURO, 1000.00, cliente.getEmail());
	}

	@Override
	protected boolean clienteValidate(Cliente cliente) {
		if (cliente.getFaixaSalarial() >= 3001 && cliente.getFaixaSalarial() <= 5000) {
			return true;
		} else {
			return false;
		}
	}

}
