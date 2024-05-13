package br.com.arq.utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;


public enum CalculoAcomodacaoType {

	    INDIVIDUALSEGQUIN("INDIVIDUAL", 100d),
	    INDIVIDUALFIMSEMANA("INDIVIDUAL", 120d),
	    CRIANCASEGQUIN("CRIANCA", 160d),
	    CRIANCAFIMSEMANA("CRIANCA", 180d),
	    ACOMPANHANTESEGQUIN("ACOMPANHANTE", 130d),
	    ACOMPANHANTEFIMSENANA("ACOMPANHANTE", 150d);

	    private   String formato;
	    private   Double preco;

	    CalculoAcomodacaoType(String formato, Double preco) {
	        this.formato = formato;
	        this.preco = preco;
	    }

	    public String getFormato() {
	        return this.formato;
	    }
 

	    public static Double getPrecoAcomodacao(LocalDateTime data) {
	        CalculoAcomodacaoType tipo =   CalculoAcomodacaoType.ACOMPANHANTEFIMSENANA;
	        DayOfWeek dayOfWeek = data.getDayOfWeek();
	        if(tipo.formato.equals("ACOMPANHANTE")) { 
	        
	            if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
	                tipo = CalculoAcomodacaoType.ACOMPANHANTEFIMSENANA;
	            } else {
	                tipo = CalculoAcomodacaoType.ACOMPANHANTESEGQUIN;
	            }
	        } 
	        if (tipo.formato.equals("CRIANCA")) {
	            if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
	                tipo = CalculoAcomodacaoType.CRIANCAFIMSEMANA;
	            } else {
	                tipo = CalculoAcomodacaoType.CRIANCASEGQUIN;
	            }
	        }
	          if (tipo.formato.equals("INDIVIDUAL")) {
	            if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
	                tipo = CalculoAcomodacaoType.INDIVIDUALFIMSEMANA;
	            } else {
	                tipo = CalculoAcomodacaoType.INDIVIDUALSEGQUIN;
	            }
	        }

	        return tipo.getPreco();
	    }

	    public String getDiaSemana(LocalDateTime data) {
	        DayOfWeek dayOfWeek = data.getDayOfWeek();
	        switch (dayOfWeek) {
	            case MONDAY:
	                return "Segunda-feira";
	            case TUESDAY:
	                return "Terça-feira";
	            case WEDNESDAY:
	                return "Quarta-feira";
	            case THURSDAY:
	                return "Quinta-feira";
	            case FRIDAY:
	                return "Sexta-feira";
	            case SATURDAY:
	                return "Sábado";
	            case SUNDAY:
	                return "Domingo";
	            default:
	                return "Desconhecido";
	        }
	    }

	    public Double getPreco() {
	        return preco;
	    }

	    public static int calcularQuantidadeDias(LocalDateTime checkin, LocalDateTime checkout) {
	        return (int) checkin.toLocalDate().until(checkout.toLocalDate()).getDays();
	    }

	    public static Double calcularValorTotal(LocalDateTime checkin, LocalDateTime checkout) {
	        int quantidadeDias = calcularQuantidadeDias(checkin, checkout);
	        Double precoDiaria = getPrecoAcomodacao(checkin);
	        return precoDiaria * quantidadeDias;
	    }

	    public static void verificarStatus(String statusAcomodacao) throws Exception {
	        if (statusAcomodacao.equals("INDISPONIVEL")) {
	            throw new Exception("Error de Quarto Indisponivel!");
	        }
	    }
}    
 