package br.com.projeto.calculadora.repository;

import br.com.projeto.calculadora.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findAll();
}
