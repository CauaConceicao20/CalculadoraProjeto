package br.com.projeto.calculadora.controller;

import br.com.projeto.calculadora.dtos.ValoresDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operacoes")
public class OperacoesController {

    @PostMapping("/soma")
    @Transactional
    public ResponseEntity<?> soma(@RequestBody @Valid ValoresDto val) {
        return null;
    }
}
