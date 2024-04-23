package br.com.projeto.calculadora.dtos;

import jakarta.validation.constraints.Positive;
import lombok.Getter;

public record ValoresDto(
        @Positive
        double numero1,
        @Positive
        double numero2) {


        @Override
        public double numero1() {
                return this.numero1;
        }
        @Override
        public double numero2() {
                return this.numero2;
        }
}
