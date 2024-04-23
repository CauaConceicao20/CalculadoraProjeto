package br.com.projeto.calculadora.service;


import br.com.projeto.calculadora.dtos.ValoresDto;
import br.com.projeto.calculadora.dtos.ValoresPrecisosDto;
import br.com.projeto.calculadora.entidade.Pessoa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperacoesServiceTest {

    @Autowired
    OperacoesService operacoesService;
    @Mock
    ValoresDto valoresDto;

    @Test
    @DisplayName("Testa metodo de soma")
    public void somaTest() {

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        assertTrue(valoresDto.numero1() >= 0);
        assertTrue(valoresDto.numero2() >= 0);

        var resultado = operacoesService.soma(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(12.0, resultado);
    }

    @Test
    @DisplayName("Testa metodo de subtração")
    public void subtracaoTest() {
        OperacoesService operacoesService = new OperacoesService();

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        assertTrue(valoresDto.numero1() >= 0);
        assertTrue(valoresDto.numero2() >= 0);

        var resultado = operacoesService.subtracao(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(8.0, resultado);
    }

    @Test
    @DisplayName("Testa metodo de multiplicação")
    public void multiplicaçãoTest() {
        OperacoesService operacoesService = new OperacoesService();

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        assertTrue(valoresDto.numero1() >= 0);
        assertTrue(valoresDto.numero2() >= 0);

        var resultado = operacoesService.multiplicacao(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(20.0, resultado);
    }

    @Test
    @DisplayName("Testa metodo de divisão")
    public void DivisaoTest() {
        OperacoesService operacoesService = new OperacoesService();

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        if(valoresDto.numero1() > 0 && valoresDto.numero2() > 0) {
            var resultado = operacoesService.divisao(valoresDto.numero1(), valoresDto.numero2());
            assertEquals(5.0, resultado);
        } else {
            fail("Não é possivel dividir por zero");
        }
    }

    @Test
    @DisplayName("Testa metodo de calculaImc")
    public void calculaImc() {
        OperacoesService operacoesService = new OperacoesService();
        Pessoa pessoa = mock(Pessoa.class);

        when(pessoa.getAltura()).thenReturn(1.74);
        when(pessoa.getPeso()).thenReturn(62.0);

        assertTrue(pessoa.getPeso() > 2.0);
        assertTrue(pessoa.getAltura() > 0.43);

        var resultado = operacoesService.calculaImc(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(20.48, resultado);

    }

    @Test
    @DisplayName("Testa metodo de calucaPotencia")
    public void calculaPotenciaTest() {
        OperacoesService operacoesService = new OperacoesService();
        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        assertTrue(valoresDto.numero1() >= 0);
        assertTrue(valoresDto.numero2() >= 0);

        var resultado = operacoesService.calculaPotenciaTest(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(100.0, resultado);
    }

    @Test
    @DisplayName("Testa metodo de converteRealEmDolar")
    public void converteRealEmDolarTest() {
        OperacoesService operacoesService = new OperacoesService();

        ValoresPrecisosDto valoresPrecisosDto = mock(ValoresPrecisosDto.class);

        when(valoresPrecisosDto.numeroPreciso1()).thenReturn(new BigDecimal("20.0"));

        assertTrue(valoresPrecisosDto.numeroPreciso1().compareTo(BigDecimal.ZERO) > 0);

        var resultado = operacoesService.converteRealEmDolar(valoresPrecisosDto.numeroPreciso1(), valoresPrecisosDto.numeroPreciso2());

        assertEquals(new BigDecimal("3.89"), resultado);
    }

    @Test
    @DisplayName("Testa metodo de converteDolarEmReal")
    public void converteDolarEmRealTest() {
        OperacoesService operacoesService = new OperacoesService();

        ValoresPrecisosDto valoresPrecisosDto = mock(ValoresPrecisosDto.class);

        when(valoresPrecisosDto.numeroPreciso1()).thenReturn(new BigDecimal("100.0"));

        assertTrue(valoresPrecisosDto.numeroPreciso1().compareTo(BigDecimal.ZERO) > 0);

        var resultado = operacoesService.converteDolarEmReal(valoresPrecisosDto.numeroPreciso1(), valoresPrecisosDto.numeroPreciso2());

        assertEquals(new BigDecimal("513.00"), resultado);
    }

    @Test
    @DisplayName("Testa metodo de calcularRaizQuadrada")
    public void calculaRaizQuadradaTest() {
        OperacoesService operacoesService = new OperacoesService();
        when(valoresDto.numero1()).thenReturn(100.0);

        assertTrue(valoresDto.numero1() > 0);

        var resultado = operacoesService.calculaRaizQuadrada(valoresDto.numero1());

        assertEquals(10.0, resultado);
    }

    @Test
    @DisplayName("Testa metodo de calcularMedia")
    public void calculaMediaTest() {
        OperacoesService operacoesService = new OperacoesService();

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        assertTrue(valoresDto.numero1() >= 0);
        assertTrue(valoresDto.numero2() >= 0);

       var resultado = operacoesService.calculaMedia(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(6.0, resultado);
    }
}