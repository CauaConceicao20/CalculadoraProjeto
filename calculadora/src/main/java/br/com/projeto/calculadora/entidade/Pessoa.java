package br.com.projeto.calculadora.entidade;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "/Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double peso;
    private double altura;

    public Pessoa(String nome ,double peso, double altura) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
    }
}
