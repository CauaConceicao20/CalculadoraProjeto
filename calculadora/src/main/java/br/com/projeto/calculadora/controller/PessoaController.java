package br.com.projeto.calculadora.controller;

import br.com.projeto.calculadora.dtos.DadosPessoa;
import br.com.projeto.calculadora.service.PessoaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    /*
    @Autowired
    PessoaService pessoaService;

    @PostMapping("/create")
    @Transactional
    public void adicionaPessoa(@RequestBody @Valid DadosPessoa dadosPessoa) {
        pessoaService.save(dadosPessoa);
    }
     */
}
