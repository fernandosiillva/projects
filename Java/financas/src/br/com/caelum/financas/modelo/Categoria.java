package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Categoria {

	@Deprecated
	public Categoria() {		
	}
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	@Id
	@SequenceGenerator(name = "seq_id_cat", sequenceName = "seq_id_cat", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_cat")
	private Integer id;
	private String nome;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
