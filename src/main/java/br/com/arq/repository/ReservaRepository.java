package br.com.arq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arq.entity.Reserva;
@Repository
public interface ReservaRepository  extends JpaRepository<Reserva,String> {

	
 
}
