package br.com.arq.request;

import java.time.LocalDateTime;



public class RequestCliente {

	private String nome;
	private String tipoQuarto;
	private LocalDateTime dataInicialReserva;
	private LocalDateTime dataFinalReserva;
	private String formatoAcomodacao;  
	
	public RequestCliente() {
		 
	}

	
 


	public RequestCliente(String nome, String tipoQuarto, LocalDateTime dataInicialReserva,
			LocalDateTime dataFinalReserva) {
		super();
		this.nome = nome;
		this.tipoQuarto = tipoQuarto;
		this.dataInicialReserva = dataInicialReserva;
		this.dataFinalReserva = dataFinalReserva;
	}

  
 


	@Override
	public String toString() {
		return "RequestCliente [nome=" + nome + ", tipoQuarto=" + tipoQuarto + ", dataInicialReserva="
				+ dataInicialReserva + ", dataFinalReserva=" + dataFinalReserva + "]";
	}


 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public LocalDateTime getDataFinalReserva() {
		return dataFinalReserva;
	}

	public void setDataFinalReserva(LocalDateTime dataFinalReserva) {
		this.dataFinalReserva = dataFinalReserva;
	}



	public LocalDateTime getDataInicialReserva() {
		return dataInicialReserva;
	}



	public void setDataInicialReserva(LocalDateTime dataInicialReserva) {
		this.dataInicialReserva = dataInicialReserva;
	}





	public String getFormatoAcomodacao() {
		return formatoAcomodacao;
	}





	public void setFormatoAcomodacao(String formatoAcomodacao) {
		this.formatoAcomodacao = formatoAcomodacao;
	}
	
	

}
