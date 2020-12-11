package br.com.alura.microservice.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.microservice.loja.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{

}
