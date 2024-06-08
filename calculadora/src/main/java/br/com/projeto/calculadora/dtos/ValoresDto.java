package br.com.projeto.calculadora.dtos;

import jakarta.validation.constraints.Positive;
import lombok.Getter;

public record ValoresDto(
        @Positive
        double numero1,
        @Positive
        double numero2) {

}
