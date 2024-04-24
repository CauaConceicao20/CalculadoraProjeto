package br.com.projeto.calculadora.service;

import br.com.projeto.calculadora.dtos.DadosPessoa;
import br.com.projeto.calculadora.repository.PessoaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {
    @Autowired
    PessoaService pessoaService;

    @Autowired
    PessoaRepository repository;
    @Test
    @DisplayName("Deve testar quantidade de pessoas cadastradas e se o registro foi salvo")
    public void deveSalvarPessoaNoBd() {
       DadosPessoa dadosPessoa = mock(DadosPessoa.class);

       when(dadosPessoa.nome()).thenReturn("fulano");
       when(dadosPessoa.altura()).thenReturn(1.64);
       when(dadosPessoa.peso()).thenReturn(42.5);

       pessoaService.save(dadosPessoa);

       var quantidade = repository.findAll().size();
       var nome = repository.findById(1L).get().getNome();

       assertEquals(1, quantidade);
       assertEquals("fulano", nome);
    }
}

