package br.com.projeto.calculadora.dtos;

import jakarta.validation.constraints.Positive;

public record ValoresDto(
        @Positive
        double numero1,
        @Positive
        double numero2) {

}
