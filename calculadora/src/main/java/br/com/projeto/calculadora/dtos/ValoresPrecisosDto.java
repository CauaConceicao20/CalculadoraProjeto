package br.com.projeto.calculadora.dtos;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ValoresPrecisosDto(
        @Positive
        BigDecimal numeroPreciso1,
        @Positive
        BigDecimal numeroPreciso2) {

    @Override
    public BigDecimal numeroPreciso1() {
        return numeroPreciso1;
    }

    @Override
    public BigDecimal numeroPreciso2() {
        return numeroPreciso2;
    }
}
