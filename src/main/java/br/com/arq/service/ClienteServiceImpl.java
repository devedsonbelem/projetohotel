package br.com.arq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arq.entity.Cliente;
import br.com.arq.interfaces.ClienteService;
import br.com.arq.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
  
	@Autowired
	private ClienteRepository clienteRepository;
	
	 public Cliente salvar(Cliente cliente) {
		 return clienteRepository.save(cliente);
	 }
	 
	 public List<Cliente> findAll(){
		 return clienteRepository.findAll();
	 }
}
