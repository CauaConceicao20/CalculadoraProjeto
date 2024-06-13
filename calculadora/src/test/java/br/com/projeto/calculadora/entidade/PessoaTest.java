package br.com.projeto.calculadora.entidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PessoaTest {

    @Test
    @DisplayName("Testa construtor Pessoa")
    void testPessoaConstructor() {

        String nome = "Jõao";
        double peso = 64.0;
        double altura = 1.70;

        Pessoa pessoa = new Pessoa(nome, peso, altura);

        assertNotNull(pessoa, "A instância da Pessoa não deve ser nula");
        assertEquals(nome, pessoa.getNome(), "O nome deve ser 'João'");
        assertEquals(peso, pessoa.getPeso(), "O peso deve ser 60.0");
        assertEquals(altura, pessoa.getAltura(), "A altura deve ser 1.70");
    }
}


