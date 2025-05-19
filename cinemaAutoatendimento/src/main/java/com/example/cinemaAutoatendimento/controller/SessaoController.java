package com.example.cinemaAutoatendimento.controller;

import com.example.cinemaAutoatendimento.model.SessaoModel;
import com.example.cinemaAutoatendimento.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @PostMapping
    public SessaoModel salvarSessao(@RequestBody SessaoModel sessao){
        return sessaoService.salvarSessao(sessao);
    }

    @PutMapping("/{id}")
    public SessaoModel atualizarSessao(@PathVariable int id, @RequestBody SessaoModel sessaoAtualizada){
        return sessaoService.atualizarSessao(id, sessaoAtualizada);
    }

    @GetMapping("/filme/{filmeId}")
    public List<SessaoModel> listarSessoesPorFilme(@PathVariable int filmeId){
        return sessaoService.listarSessoesPorFilme(filmeId);
    }

    @GetMapping("/{id}")
    public Optional<SessaoModel> acharSessaoPorId(@PathVariable int id){
        return sessaoService.acharSessaoPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSessao(@PathVariable int id){
        boolean deleted = sessaoService.excluirSessao(id);
        if (deleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
