package com.example.springboot.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PACIENTE")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private BigDecimal peso;
	private BigDecimal altura;
	private BigDecimal gordura;
	private BigDecimal imc;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public BigDecimal getAltura() {
		return altura;
	}
	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}
	public BigDecimal getGordura() {
		return gordura;
	}
	public void setGordura(BigDecimal gordura) {
		this.gordura = gordura;
	}
	public BigDecimal getImc() {
		return imc;
	}
	public void setImc(BigDecimal imc) {
		this.imc = imc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
