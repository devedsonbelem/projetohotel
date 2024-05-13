package br.com.arq.request;

import java.time.LocalDateTime;

public class ReservaRequest{
	private Long idReserva;
   
    private String nome;
    private LocalDateTime dataCheckIn;
    private LocalDateTime dataCheckOut;
    private Integer quantidadeDias;
    private Double valorTotal;
    private String tipoPagamento;
    private Integer numeroQuarto;
	public Long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
 
	public LocalDateTime getDataCheckIn() {
		return dataCheckIn;
	}
	public void setDataCheckIn(LocalDateTime dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}
	public LocalDateTime getDataCheckOut() {
		return dataCheckOut;
	}
	public void setDataCheckOut(LocalDateTime dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
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
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
 
    
    
    
}
