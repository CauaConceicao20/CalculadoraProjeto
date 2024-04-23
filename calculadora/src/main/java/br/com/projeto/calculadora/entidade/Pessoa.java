package br.com.projeto.calculadora.entidade;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Pessoa {

    private String nome;
    private double peso;
    private double altura;

    public Pessoa(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }
}
