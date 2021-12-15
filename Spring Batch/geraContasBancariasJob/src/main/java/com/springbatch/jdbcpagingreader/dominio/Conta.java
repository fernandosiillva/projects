package com.springbatch.jdbcpagingreader.dominio;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private TipoConta tipo;
	private double limite;
	private String clienteId;
	
	public Conta() {}
	
	public Conta(TipoConta tipo, double limite, String clienteId) {
		this.id = id++;
		this.tipo = tipo;
		this.limite = limite;
		this.clienteId = clienteId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoConta getTipo() {
		return tipo;
	}
	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public String getClienteId() {
		return clienteId;
	}
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	
	@Override
	public String toString() {
		return "Conta [tipo=" + tipo + ", limite=" + limite + ", clienteId=" + clienteId + "]";
	}
	
}
