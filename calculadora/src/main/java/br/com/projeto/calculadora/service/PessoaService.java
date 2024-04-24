package br.com.projeto.calculadora.service;

import br.com.projeto.calculadora.dtos.DadosPessoa;
import br.com.projeto.calculadora.entidade.Pessoa;
import br.com.projeto.calculadora.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public void save(DadosPessoa dados){
        Pessoa pessoa = new Pessoa(dados.nome(), dados.altura(), dados.peso());
        repository.save(pessoa);
    }
}
