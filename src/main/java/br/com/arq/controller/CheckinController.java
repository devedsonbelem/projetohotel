package br.com.arq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arq.entity.Reserva;
import br.com.arq.service.PagamentoServiceImpl;

@RestController
@RequestMapping("/api/checkin")
public class CheckinController {
 
	 @Autowired
	    private  PagamentoServiceImpl pagamentoService;
 
	 
	    @PutMapping("/realizar/{id}")
	    public ResponseEntity<?> realizarCheckin(@PathVariable("id") String id,@RequestBody Reserva reserva) {
	        try {
	        	
	            return ResponseEntity.ok(pagamentoService.gerarTotalQuartos(new Long(id), reserva));
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().build();
	        }
	    }	
	    
	    @PutMapping("/calcular/{id}")
	    public ResponseEntity<?> calcularCheckin(@PathVariable("id") String id, @RequestBody Reserva reserva) {
	        try {
	        	
	            return ResponseEntity.ok(pagamentoService.gerarTotalQuarto(new Long(id),reserva));
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().build();
	        }
	    }
}

