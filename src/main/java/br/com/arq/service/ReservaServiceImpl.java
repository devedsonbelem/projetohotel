package br.com.arq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arq.entity.Quarto;
import br.com.arq.entity.Reserva;
import br.com.arq.repository.QuartoRepository;
import br.com.arq.repository.ReservaRepository;


@Service
public class ReservaServiceImpl {

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private QuartoRepository quartorepository;
	
	
	
	public String buscarQuartoPorId(String numeroQuarto) {
		Optional<Quarto> respQuarto = this.quartorepository.findByNumeroQuarto(numeroQuarto);
	    return respQuarto.get().toString();
	}
	
	 

	public List<Reserva> findAll() {
		return reservaRepository.findAll();
	}

	public Reserva findByCode(String id) {
		Optional<Reserva> respReserva = reservaRepository.findById(id);
		if (respReserva.isEmpty()) {
			throw new IllegalArgumentException("404");
		} else {
			return respReserva.get();
		}
	}

	public void deleteReserva(String id) throws Exception {
		Optional<Reserva> respReserva = reservaRepository.findById(id);
	if (respReserva.isEmpty()) {
		throw new IllegalArgumentException("404");
		}

		reservaRepository.delete(respReserva.get());
	}

	 public  Reserva saveReserva(Reserva reserva) throws Exception{
		 return this.reservaRepository.save(reserva);
	 }
}
