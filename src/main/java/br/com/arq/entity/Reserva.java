package br.com.arq.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
   
	  @Id
	  @Column(name="id_reserva")
	  private String idReserva;
 	
 	  private LocalDateTime checkin;

     private LocalDateTime checkout;
     private Integer quantidadeDias;
     private Double valorTotal;
 	 @Column(name = "tipo_pagamento")
 	 @JsonProperty("tipo_pagamento")
     private String tipoPagamento;

     private String formato;
     
     @OneToOne(cascade=CascadeType.ALL)
     @JoinColumn(name = "id_quarto", referencedColumnName = "id_quarto")
     private Quarto quarto; 
     
     @OneToOne
     @JoinColumn(name = "id_cliente",referencedColumnName = "id_cliente")
     private Cliente cliente;
 


 

	
	public Reserva(String idReserva,   LocalDateTime checkout,
			Integer quantidadeDias, Double valorTotal, String tipoPagamento,
			String  formatoAcomodacao, Quarto quarto ) {
		super();
		this.idReserva = (idReserva==null)? UUID.randomUUID().toString():idReserva;
		this.checkin = LocalDateTime.now();
		this.checkout = checkout;
		this.quantidadeDias = quantidadeDias;
		this.valorTotal = valorTotal;
		this.tipoPagamento = tipoPagamento;
		this.quarto = quarto;
	 
	}

	public Reserva() {
		this.idReserva = UUID.randomUUID().toString();
		this.checkin = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva  + ", quarto=" + quarto
				+ ",  " + ", checkin=" + checkin + ", checkout="
				+ checkout + ", quantidadeDias=" + quantidadeDias + ", valorTotal=" + valorTotal + ", tipoPagamento="
				+ tipoPagamento  + "]";
	}

 
   
	public Integer getQuantidadeDias() {
		return quantidadeDias;
	}
	public void setQuantidadeDias(Integer quantidadeDias) {
		this.quantidadeDias = quantidadeDias;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
 
     
 
 
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
 
   
	 


	public String getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

 

	public LocalDateTime getCheckin() {
		return checkin;
	}


	public void setCheckin(LocalDateTime checkin) {
		this.checkin = checkin;
	}


	public LocalDateTime getCheckout() {
		return checkout;
	}


	public void setCheckout(LocalDateTime checkout) {
		this.checkout = checkout;
	}

 

 
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
	
     
	
	
	
}
