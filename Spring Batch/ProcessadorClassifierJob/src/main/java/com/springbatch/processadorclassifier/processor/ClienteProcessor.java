package com.springbatch.processadorclassifier.processor;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.processadorclassifier.dominio.Cliente;

@SuppressWarnings("rawtypes")
public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

	@Override
	public Cliente process(Cliente cliente) throws Exception {
		System.out.println(String.format("\nAplicando regras de negócio no cliente %s", cliente.getNome()));
		return cliente;
	}

}
