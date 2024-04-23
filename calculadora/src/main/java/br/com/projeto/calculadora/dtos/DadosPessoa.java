package br.com.projeto.calculadora.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DadosPessoa(
        @NotBlank
        String nome,
        @Positive
        double altura,
        @Positive
        double peso) {
}
