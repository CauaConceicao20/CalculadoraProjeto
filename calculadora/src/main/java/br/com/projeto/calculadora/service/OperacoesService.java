package br.com.projeto.calculadora.service;

import br.com.projeto.calculadora.exception.EntradaInvalida;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class OperacoesService {

   public static final String VALORMENORQUEZERO = "Não permitir divisão por zero";

    public double soma(double valor1, double valor2) {
        double resultado = valor1 + valor2;
        return Math.round(resultado* 10) / 10.0;
    }

    public double subtracao(double valor1, double valor2) {
        double resultado = valor1 - valor2;
        return  Math.round(resultado * 10) / 10.0;
    }

    public double multiplicacao(double valor1, double valor2) {
        double resultado = valor1 * valor2;
        return Math.round(resultado * 10) / 10.0;
    }

    public double divisao(double valor1, double valor2) throws ArithmeticException{
        if(valor1 <= 0 || valor2 <= 0 || Double.isNaN(valor1) || Double.isNaN(valor2)) {
            throw new ArithmeticException(VALORMENORQUEZERO);
        }else {
            return  valor1 / valor2;
        }
    }

    public double calculaImc(double altura, double peso) throws EntradaInvalida {
        if(altura <= 0 || peso <= 0) {
            throw new EntradaInvalida(VALORMENORQUEZERO);
        }else {
            var imc = peso / (altura * altura);
            return Math.round(imc * 100) / 100.0;
        }
    }

    public double calculaPotencia(double base, double expoente) throws EntradaInvalida{
        if(base <= 0 || expoente <= 0) {
            throw new EntradaInvalida(VALORMENORQUEZERO);
        }else {
            return Math.pow(base, expoente);
        }
    }

    public BigDecimal converteRealEmDolar(BigDecimal real) throws EntradaInvalida {
        BigDecimal taxaDeCambio = new BigDecimal("0.19");
        if(real.compareTo(BigDecimal.ZERO) <= 0) {
            throw new EntradaInvalida(VALORMENORQUEZERO);
        }else {
            return real.multiply(taxaDeCambio).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public BigDecimal converteDolarEmReal(BigDecimal dolar) throws EntradaInvalida {
        BigDecimal taxaDeCambio = new BigDecimal("5.13");
        if(dolar.compareTo(BigDecimal.ZERO) <= 0) {
            throw new EntradaInvalida(VALORMENORQUEZERO);
        }else {
            return dolar.multiply(taxaDeCambio).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public double calculaRaizQuadrada(double numero1) throws EntradaInvalida {
        if(numero1 <= 0) {
            throw new EntradaInvalida(VALORMENORQUEZERO);
        }else {
            return Math.sqrt(numero1);
        }
    }

    public double calculaMedia(double valor1, double valor2) throws EntradaInvalida {
        if(valor1 <= 0 || valor2 <=0) {
            throw new EntradaInvalida(VALORMENORQUEZERO);
        }else {
            return (valor1 + valor2) / 2;
        }
    }
}