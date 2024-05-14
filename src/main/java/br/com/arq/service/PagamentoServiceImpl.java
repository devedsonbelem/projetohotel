package br.com.arq.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arq.entity.Cliente;
import br.com.arq.entity.Quarto;
import br.com.arq.entity.Reserva;
import br.com.arq.repository.QuartoRepository;
import br.com.arq.utils.CalculoAcomodacaoType;

@Service
public class PagamentoServiceImpl {

	@Autowired
	private final ReservaServiceImpl reservaService;

	@Autowired
	private final QuartoServiceImpl quartoService;

	@Autowired
	private final ClienteServiceImpl clienteService;

	@Autowired
	private final QuartoRepository quartoRepository;

	public PagamentoServiceImpl(ReservaServiceImpl reservaService, QuartoServiceImpl quartoService,
			ClienteServiceImpl clienteService, QuartoRepository quartoRepository) {
		super();
		this.reservaService = reservaService;
		this.quartoService = quartoService;
		this.clienteService = clienteService;
		this.quartoRepository = quartoRepository;
	}

	public Quarto buscarQuartoPorId(String numeroQuarto) {
		Optional<Quarto> respQuarto = this.quartoRepository.findByNumeroQuarto(numeroQuarto);
		return respQuarto.get();
	}

	public Reserva gerarTotalQuartos(Long id, Reserva reserva) throws Exception {
		try {
			
			Double valorDia = CalculoAcomodacaoType.getPrecoAcomodacao(reserva.getCheckin(),reserva.getFormato());
			reserva.setValorTotal(
					CalculoAcomodacaoType.calcularValorTotalAcomodacao(reserva.getCheckin(), reserva.getCheckout(), valorDia)
					);
 
			reserva.setIdReserva(UUID.randomUUID().toString());
			reserva.setQuantidadeDias(
					CalculoAcomodacaoType.calcularQuantidadeDias(reserva.getCheckin(), reserva.getCheckout()));
			reserva.setTipoPagamento(reserva.getTipoPagamento());
			reserva.setQuarto(this.alterarIndisponivel(id, reserva.getQuarto()));
			clienteService.salvar(reserva.getCliente());
			reserva.setCliente(reserva.getCliente());
			reserva.setIdReserva(UUID.randomUUID().toString());
			reserva = reservaService.saveReserva(reserva);

			Quarto quarto = alterarIndisponivel(id, reserva.getQuarto());
			reserva.setQuarto(quarto);
			return reserva;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error:" + ex.getMessage());
		}
	}

	public Reserva salvarReserva(Reserva reserva) throws Exception {
		return reservaService.saveReserva(reserva);
	}

	public Quarto alterarIndisponivel(Long id, Quarto quarto) throws Exception {
		return quartoRepository.findById(id).map(record -> {
			record.setNumeroQuarto(quarto.getNumeroQuarto());
			record.setStatusAcomodacao("INDISPONIVEL");
			Quarto updated = quartoRepository.save(record);
			return updated;
		}).orElseThrow(() -> new Exception("Erro na Hora de Alterar"));
	}

	public Cliente salvarTabelaCliente(Cliente cliente) throws Exception {
		if (cliente.getIdCliente() == null) {
			throw new IllegalArgumentException("O ID do cliente não pode ser nulo ao salvar a reserva.");
		}

		cliente.setIdCliente(UUID.randomUUID().toString());
		cliente = clienteService.salvar(cliente);
		return cliente;
	}

	public Reserva gerarTotalQuarto(Long id, Reserva reserva) throws Exception {
		try {

			Double valorDia = CalculoAcomodacaoType.getPrecoAcomodacao(reserva.getCheckin(),reserva.getFormato());
			reserva.setValorTotal(
					CalculoAcomodacaoType.calcularValorTotalAcomodacao(reserva.getCheckin(), reserva.getCheckout(), valorDia)
					);
 
			reserva.setIdReserva(UUID.randomUUID().toString());
			reserva.setQuantidadeDias(
					CalculoAcomodacaoType.calcularQuantidadeDias(reserva.getCheckin(), reserva.getCheckout()));
			reserva.setTipoPagamento(reserva.getTipoPagamento());
			reserva.setQuarto(this.alterarIndisponivel(id, reserva.getQuarto()));
			return reserva;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error ..." + ex.getMessage());
		}
	}  

}
