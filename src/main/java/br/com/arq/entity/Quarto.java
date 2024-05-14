package br.com.arq.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quarto")
public class Quarto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_quarto")
	private Long idQuarto;

	@Column(name = "numero_quarto")
	@JsonProperty("numero_quarto")
	private String numeroQuarto;
	
	
	@Column(name = "status_acomodacao")
	@JsonProperty("status_acomodacao")
	private String statusAcomodacao;
	
	
	@OneToOne(mappedBy = "quarto", cascade = { CascadeType.ALL })
	@JsonIgnore
    private Reserva reserva;

	public Quarto() {

	}

	public Quarto(Long idQuarto, String numeroQuarto, String statusAcomodacao) {
		super();
		this.idQuarto = idQuarto;
		this.numeroQuarto = numeroQuarto;
		this.statusAcomodacao = statusAcomodacao;
 
	}

	@Override
	public String toString() {
		return "Quarto [idQuarto=" + idQuarto + ", numeroQuarto=" + numeroQuarto + ", statusAcomodacaoType="
				+ statusAcomodacao +   "]";
	}

	public Long getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(Long idQuarto) {
		this.idQuarto = idQuarto;
	}

	public String getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public String getStatusAcomodacao() {
		return statusAcomodacao;
	}

	public void setStatusAcomodacao(String statusAcomodacao) {
		this.statusAcomodacao = statusAcomodacao;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}
