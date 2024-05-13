package br.com.arq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.arq.entity.Quarto;
import br.com.arq.service.QuartoServiceImpl;
 

@SpringBootApplication
public class HotelariaApplication implements CommandLineRunner{
 
 	//@Autowired
    // private  QuartoServiceImpl service;
	
	public static void main(String[] args) {
		SpringApplication.run(HotelariaApplication.class, args);
	}

	
	  
	public List<Quarto> mockInsertQuartosDisponiveis(int start, int end) {
	 List<Quarto> quartosDisponiveis = new ArrayList<>();
      for (int i = start; i <= end; i++) {
          Quarto quarto = new Quarto();
          quarto.setIdQuarto((long) i);
          quarto.setNumeroQuarto(String.valueOf(i));
          quarto.setStatusAcomodacao("DISPONIVEL");
          quartosDisponiveis.add(quarto);
      }

      return quartosDisponiveis;
	}
      public List<Quarto> mockInsertQuartosIndisponiveis(int start, int end) {
      List<Quarto> quartosIndisponiveis = new ArrayList<>();
      for (int i = start; i <= end; i++) {
          Quarto quarto = new Quarto();
          quarto.setIdQuarto((long) i);
          quarto.setNumeroQuarto(String.valueOf(i));
          quarto.setStatusAcomodacao("INDISPONIVEL");
          quartosIndisponiveis.add(quarto);
      }
      return quartosIndisponiveis;
	}



	@Override
	public void run(String... args) throws Exception {
 		try {
      // service.inserirQuartosPrimeiraVez(mockInsertQuartosDisponiveis(1,30));
 	 //	 service.inserirQuartosPrimeiraVez(mockInsertQuartosIndisponiveis(31,40));
 	 //	 System.out.println("Ok Primeira Vez Mockado");
 		}catch(Exception ex) {
 	  System.out.println("...Error na Insercao Mokadas"+ ex.getMessage());
 		}
	}
	
	
	
}
