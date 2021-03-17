package com.springbatch.jdbcpagingreader.dominio;

public class Cliente {
	private String nome;
	private double faixa_salarial;
	private int idade;
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getFaixaSalarial() {
		return faixa_salarial;
	}
	
	public void setFaixaSalarial(double faixaSalarial) {
		this.faixa_salarial = faixaSalarial;
	}
	
	@Override
	public String toString() {
		return "Cliente{" +
	                "nome='" + nome + "'" +
	                ", faixaSalarial ='" + faixa_salarial + "'" +
	                ", idade='" + idade + "'" +
	                ", email='" + email + "'" +
	                '}';
	}

}