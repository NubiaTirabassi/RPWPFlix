package com.br.BackendRPWPFlix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.BackendRPWPFlix.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	

}
