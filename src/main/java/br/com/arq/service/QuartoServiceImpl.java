package br.com.arq.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.arq.entity.Quarto;
import br.com.arq.interfaces.QuartoService;
import br.com.arq.repository.QuartoRepository;
import br.com.arq.utils.MapError;


@Service
public class QuartoServiceImpl implements QuartoService {

	@Autowired
	private final QuartoRepository quartoRepository;
 

	private Map<String, Object> mapaQuarto;
	private List<Quarto> quartosDisponiveis;
	private List<Quarto> quartosIndisponiveis;

	public QuartoServiceImpl(QuartoRepository quartoRepository) {
		this.quartoRepository = quartoRepository;

	}

	public Map<String, Object> findByIdQuartoLista(Long id) throws Exception {
		try {
			Quarto respQuarto = this.findAllByStatusDisponivel().stream()
					.filter(chave -> chave.getIdQuarto().equals(id)).findAny()
					.orElseThrow(() -> new IllegalArgumentException("Error Quarto Nao ENcontrado"));
			mapaQuarto.put("quarto", respQuarto);
			return mapaQuarto;
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("" + MapError.getMapa().get("404"));
		} catch (Exception ex) {
			throw new Exception("" + MapError.getMapa().get("500"));
		}
	}

	public Quarto findByIdQuarto(Long id) throws Exception {
		Optional<Quarto> respQuarto = this.quartoRepository.findById(id);
		if (respQuarto.isEmpty()) {
			throw new IllegalArgumentException("404");
		} else {
			return respQuarto.get();
		}
	}

	public List<Quarto> inserirQuartosPrimeiraVez(List<Quarto> quartos) {
		return this.quartoRepository.saveAll(quartos);
	}

	public Quarto inserirQuartoPorNumero(Quarto quarto) {

		Optional<Quarto> respQuarto = this.quartoRepository.findByNumeroQuarto(quarto.getNumeroQuarto());
		if (respQuarto.isPresent()) {
			throw new IllegalArgumentException("Quarto Existente nao pode ser Inserido");
		}
		Quarto quartos = respQuarto.get();
		quartos.setStatusAcomodacao("DISPONVEL");
		return this.quartoRepository.save(quartos);
	}

	public Quarto inserirQuartoPorId(Quarto quarto) {
		Optional<Quarto> respQuarto = this.quartoRepository.findById(quarto.getIdQuarto());
		if (respQuarto.isPresent()) {
			throw new IllegalArgumentException("Quarto Existente nao pode ser Inserido");
		}
		Quarto quartos = respQuarto.get();
		quartos.setStatusAcomodacao(quartos.getStatusAcomodacao());
		return this.quartoRepository.save(quartos);
	}

 
	public List<Quarto> findAllByStatusIndisponivel() {
		List<Quarto> quartosDisponiveis = quartoRepository.findAll().stream()
				.filter(quarto -> quarto.getStatusAcomodacao().equals("INDISPONIVEL"))
				.collect(Collectors.toList());
		return quartosDisponiveis;
	}

	public List<Quarto> findAllByStatusDisponivel() {
		List<Quarto> quartosDisponiveis = quartoRepository.findAll().stream()
				.filter(quarto -> quarto.getStatusAcomodacao().equals("DISPONIVEL"))
				.collect(Collectors.toList());
		return quartosDisponiveis;
	}

 
	public List<Quarto> getQuartosDisponiveis() {
		return quartosDisponiveis;
	}

	public void setQuartosDisponiveis(List<Quarto> quartosDisponiveis) {
		this.quartosDisponiveis = quartosDisponiveis;
	}

	public List<Quarto> getQuartosIndisponiveis() {
		return quartosIndisponiveis;
	}

	public void setQuartosIndisponiveis(List<Quarto> quartosIndisponiveis) {
		this.quartosIndisponiveis = quartosIndisponiveis;
	}

	public Map<String, Object> getMapaQuarto() {
		return mapaQuarto;
	}

  
	public Quarto save(Quarto quarto) {
		return this.quartoRepository.save(quarto);
	}

}
