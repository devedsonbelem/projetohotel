package br.com.arq.entity;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
 
 	@Id
 	@Column(name="id_cliente")
 	private String idCliente;
 	private String nome;
 	private String email;
 	@OneToOne(mappedBy="cliente",cascade= {CascadeType.ALL})
 	private Reserva reserva;
 	
    
     public Cliente() {
		this.idCliente= UUID.randomUUID().toString();
	}
     
     
	public Cliente(String idCliente, String nome, String email) {
		super();
		this.idCliente = (idCliente == null) ?  UUID.randomUUID().toString() : idCliente;
		this.nome = nome;
		this.email = email;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + "]";
	}


	 
	public String getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
  
 
 
}
