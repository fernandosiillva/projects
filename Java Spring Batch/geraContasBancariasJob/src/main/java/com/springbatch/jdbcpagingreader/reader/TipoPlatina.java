package com.springbatch.jdbcpagingreader.reader;

import com.springbatch.jdbcpagingreader.dominio.Cliente;
import com.springbatch.jdbcpagingreader.dominio.Conta;
import com.springbatch.jdbcpagingreader.dominio.TipoConta;

public class TipoPlatina extends TipoContaAbstract {

	public TipoPlatina(TipoContaAbstract proximo) {
		super(proximo);
	}

	@Override
	protected Conta novaContaCriada(Cliente cliente) {
		return new Conta(TipoConta.PLATINA, 2500.00, cliente.getEmail());
	}

	@Override
	protected boolean clienteValidate(Cliente cliente) {
		if (cliente.getFaixaSalarial() >= 5001 && cliente.getFaixaSalarial() <= 10000) {
			return true;
		} else {
			return false;
		}
	}

}
