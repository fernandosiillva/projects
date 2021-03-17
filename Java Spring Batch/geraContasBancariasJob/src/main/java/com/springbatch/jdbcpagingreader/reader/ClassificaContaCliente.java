package com.springbatch.jdbcpagingreader.reader;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.jdbcpagingreader.dominio.Cliente;
import com.springbatch.jdbcpagingreader.dominio.Conta;

public class ClassificaContaCliente implements ItemProcessor<Cliente, Conta> {

	@Override
	public Conta process(Cliente cliente) throws Exception {
		TipoContaAbstract tipoContaAbstract = new TipoPrata(new TipoOuro(new TipoPlatina(new TipoDiamante(new TipoNull()))));
		return tipoContaAbstract.novaConta(cliente);
	}

}
