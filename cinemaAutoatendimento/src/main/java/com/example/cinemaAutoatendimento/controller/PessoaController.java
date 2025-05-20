package com.example.cinemaAutoatendimento.controller;


import com.example.cinemaAutoatendimento.model.PessoaModel;
import com.example.cinemaAutoatendimento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaModel salvarPessoa(@RequestBody PessoaModel pessoa){
        return pessoaService.salvarPessoa(pessoa);
    }

    @GetMapping
    public List<PessoaModel> listarPessoas(){
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> buscarPessoaPorId(@PathVariable int id){
        try {
            PessoaModel pessoa = pessoaService.buscarPessoaPorId(id);
            return ResponseEntity.ok(pessoa);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public PessoaModel atualizarPessoa(@PathVariable int id, @RequestBody String nome){
        return pessoaService.atualizarPessoa(id, nome);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable int id) {
        boolean deleted = pessoaService.excluirPessoa(id);
        if (deleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
