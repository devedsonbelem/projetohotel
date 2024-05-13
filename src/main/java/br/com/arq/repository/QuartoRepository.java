package br.com.arq.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arq.entity.Quarto;

public interface QuartoRepository extends JpaRepository<Quarto,Long> {

	public Optional<Quarto> findByNumeroQuarto(String numeroQuarto);
}