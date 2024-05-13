package br.com.arq.dto;

import java.time.LocalDateTime;

 
 
import br.com.arq.entity.Cliente;
import br.com.arq.entity.Quarto;

 

public class ReservaDto {
    private Long idReserva;
    private Quarto quarto; 
	private Cliente cliente;
    private LocalDateTime dataCheckIn;
    private LocalDateTime dataCheckOut;
    private Integer quantidadeDias;
    private Double valorTotal;
    private String tipoPagamento;
    private Integer numeroQuarto;
    
    public ReservaDto() {
		 
	}
    
    
    
   




	public Long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
  
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
    
    
    
}
