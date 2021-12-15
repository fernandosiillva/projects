package com.springbatch.jdbcpagingreader.reader;

import com.springbatch.jdbcpagingreader.dominio.Cliente;
import com.springbatch.jdbcpagingreader.dominio.Conta;
import com.springbatch.jdbcpagingreader.dominio.TipoConta;

public class TipoDiamante extends TipoContaAbstract {

	public TipoDiamante(TipoContaAbstract proximo) {
		super(proximo);
	}

	@Override
	protected Conta novaContaCriada(Cliente cliente) {
		return new Conta(TipoConta.DIAMANTE, 5000.00, cliente.getEmail());
	}

	@Override
	protected boolean clienteValidate(Cliente cliente) {
		if (cliente.getFaixaSalarial() > 10000) {
			return true;
		} else {
			return false;
		}
	}

}
