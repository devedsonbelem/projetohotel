package br.com.arq.servicetest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.arq.entity.Quarto;
 
import br.com.arq.interfaces.QuartoService;
import br.com.arq.repository.QuartoRepository;

 
public class QuartoServiceTest {
 
    private QuartoRepository quartoRepository;

    
    private QuartoService quartoService;

  
    public void testInserirQuartos() {
        // Mock dos quartos disponíveis
      

        // Mock da operação de persistência
    //    when(quartoRepository.saveAll(any())).thenReturn(quartosDisponiveis);

        // Inserção dos quartos
     //   quartoService.inserirQuartos(quartosDisponiveis, quartosIndisponiveis);

        // Verificação se a operação de persistência foi chamada corretamente
      //  verify(quartoRepository, times(1)).saveAll(any());
    }
}
