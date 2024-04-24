package br.com.projeto.calculadora.service;

import br.com.projeto.calculadora.dtos.DadosPessoa;
import br.com.projeto.calculadora.dtos.ValoresDto;
import br.com.projeto.calculadora.dtos.ValoresPrecisosDto;
import br.com.projeto.calculadora.exception.EntradaInvalida;
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

        var resultado = operacoesService.soma(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(12.0, resultado);
    }

    @Test
    @DisplayName("Testa metodo de subtração")
    public void subtracaoTest() {

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        var resultado = operacoesService.subtracao(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(8.0, resultado);
    }

    @Test
    @DisplayName("Testa metodo de multiplicação")
    public void multiplicaçãoTest() {

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        var resultado = operacoesService.multiplicacao(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(20.0, resultado);
    }

    @Test
    @DisplayName("Testa metodo de divisão")
    public void DivisaoTest() {
        ;

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        var resultado = operacoesService.divisao(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(5.0, resultado);
    }

    @Test
    @DisplayName("Deve lancar Exception quando divisão for por zero")
    public void DivisaoPorZeroTest() {
        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(0.0);

        assertThrows(ArithmeticException.class, () -> operacoesService.divisao(valoresDto.numero1(), valoresDto.numero2()));
    }
    @Test
    @DisplayName("Testa metodo de calculaImc")
    public void calculaImc() throws EntradaInvalida {

        DadosPessoa dadosPessoa = mock(DadosPessoa.class);

        when(dadosPessoa.altura()).thenReturn(1.74);
        when(dadosPessoa.peso()).thenReturn(62.0);

        var resultado = operacoesService.calculaImc(dadosPessoa.altura(), dadosPessoa.peso());

        assertEquals(20.48, resultado);

    }

    @Test
    @DisplayName("CalculoDeImc deve lancar Exception quando entrada ser menor ou igual a zero")
    public void TestCalculoDeImcComValoresZMenorIgualZero() {
        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(0.0);


        assertThrows(EntradaInvalida.class, () -> operacoesService.calculaImc(valoresDto.numero1(), valoresDto.numero2()));
    }

    @Test
    @DisplayName("Testa metodo de calucaPotencia")
    public void calculaPotenciaTest() throws EntradaInvalida {

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        var resultado = operacoesService.calculaPotencia(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(100.0, resultado);
    }

    @Test
    @DisplayName("Calculo de potencia Deve lancar Exception quando houver entrada menor ou igual a zero")
    public void TestaPotenciaComValoresZMenorIgualZero() {

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(0.0);


        assertThrows(EntradaInvalida.class, () -> operacoesService.calculaPotencia(valoresDto.numero1(), valoresDto.numero2()));
    }

    @Test
    @DisplayName("Testa metodo de converteRealEmDolar")
    public void converteRealEmDolarTest() throws EntradaInvalida {

        ValoresPrecisosDto valoresPrecisosDto = mock(ValoresPrecisosDto.class);

        when(valoresPrecisosDto.numeroPreciso1()).thenReturn(new BigDecimal("30.0"));

        assertTrue(valoresPrecisosDto.numeroPreciso1().compareTo(BigDecimal.ZERO) > 0);

        var resultado = operacoesService.converteRealEmDolar(valoresPrecisosDto.numeroPreciso1());

        assertEquals(new BigDecimal("5.70"), resultado);
    }

    @Test
    @DisplayName("Converso de real em dolar deve lancar exception quando houver entrada menor ou igual a zero")
    public void TestaConverteRealEmDolarComValoresZMenorIgualZero() {

        ValoresPrecisosDto valoresPrecisosDto = mock(ValoresPrecisosDto.class);

        when(valoresPrecisosDto.numeroPreciso1()).thenReturn(new BigDecimal("0.0"));

        assertThrows(EntradaInvalida.class, () ->  operacoesService.converteRealEmDolar(valoresPrecisosDto.numeroPreciso1()));
    }

    @Test
    @DisplayName("Testa metodo de converteDolarEmReal")
    public void converteDolarEmRealTest() throws EntradaInvalida {

        ValoresPrecisosDto valoresPrecisosDto = mock(ValoresPrecisosDto.class);

        when(valoresPrecisosDto.numeroPreciso1()).thenReturn(new BigDecimal("100.0"));

        assertTrue(valoresPrecisosDto.numeroPreciso1().compareTo(BigDecimal.ZERO) > 0);

        var resultado = operacoesService.converteDolarEmReal(valoresPrecisosDto.numeroPreciso1());

        assertEquals(new BigDecimal("513.00"), resultado);
    }

    @Test
    @DisplayName("Conversor de dolar em real deve lancar exception quando houver entrada menor ou igual a zero")
    public void TestaConverteDolarEmRealComValoresZMenorIgualZero() {

        ValoresPrecisosDto valoresPrecisosDto = mock(ValoresPrecisosDto.class);

        when(valoresPrecisosDto.numeroPreciso1()).thenReturn(new BigDecimal("0.0"));

        assertThrows(EntradaInvalida.class, () -> operacoesService.converteDolarEmReal(valoresPrecisosDto.numeroPreciso1()));
    }

    @Test
    @DisplayName("Testa metodo de calcularRaizQuadrada")
    public void calculaRaizQuadradaTest() throws EntradaInvalida {

        when(valoresDto.numero1()).thenReturn(100.0);

        assertTrue(valoresDto.numero1() > 0);

        var resultado = operacoesService.calculaRaizQuadrada(valoresDto.numero1());

        assertEquals(10.0, resultado);
    }

    @Test
    @DisplayName("calculo de Raiz Quadrada deve lancar exception quando houver entrada menor ou igual a zero")
    public void TestacalculaRaizQuadradaComValoresZMenorIgualZero() {

        when(valoresDto.numero1()).thenReturn(0.0);

        assertThrows(EntradaInvalida.class, () -> operacoesService.calculaRaizQuadrada(valoresDto.numero1()));
    }

    @Test
    @DisplayName("Testa metodo de calcularMedia")
    public void calculaMediaTest() throws EntradaInvalida {

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(2.0);

        assertTrue(valoresDto.numero1() > 0);
        assertTrue(valoresDto.numero2() > 0);

        var resultado = operacoesService.calculaMedia(valoresDto.numero1(), valoresDto.numero2());

        assertEquals(6.0, resultado);
    }

    @Test
    @DisplayName("calculo de Media deve lancar exception quando houver entrada menor ou igual a zero")
    public void calculaMediaComValoresMenorIgualAZero() {

        when(valoresDto.numero1()).thenReturn(10.0);
        when(valoresDto.numero2()).thenReturn(0.0);

        assertThrows(EntradaInvalida.class, () -> operacoesService.calculaMedia(valoresDto.numero1(), valoresDto.numero2()));
    }
}