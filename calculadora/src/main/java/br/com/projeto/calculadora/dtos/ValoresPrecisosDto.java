package br.com.projeto.calculadora.dtos;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ValoresPrecisosDto(
        @Positive
        BigDecimal numeroPreciso1,
        @Positive
        BigDecimal numeroPreciso2) {
}
