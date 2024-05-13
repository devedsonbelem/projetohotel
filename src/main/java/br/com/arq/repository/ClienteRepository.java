package br.com.arq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arq.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,String> {

}
