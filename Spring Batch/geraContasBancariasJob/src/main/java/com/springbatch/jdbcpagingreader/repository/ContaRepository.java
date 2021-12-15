package com.springbatch.jdbcpagingreader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbatch.jdbcpagingreader.dominio.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
