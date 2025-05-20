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

    //CRUD
    @PostMapping
    public SessaoModel salvarSessao(@RequestBody SessaoModel sessao) {
        return sessaoService.salvarSessao(sessao);
    }

    @PutMapping("/{id}")
    public SessaoModel atualizarSessao(@PathVariable Long id, @RequestBody SessaoModel sessaoAtualizada) {
        return sessaoService.atualizarSessao(id, sessaoAtualizada);
    }

    @GetMapping
    public List<SessaoModel> listarSessoes() {
        return sessaoService.listarSessoes();
    }

    @GetMapping("/filme/{filmeId}")
    public List<SessaoModel> listarSessoesPorFilme(@PathVariable Long filmeId) {
        return sessaoService.listarSessoesPorFilme(filmeId);
    }

    @GetMapping("/{id}")
    public Optional<SessaoModel> acharSessaoPorId(@PathVariable Long id) {
        return sessaoService.acharSessaoPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSessao(@PathVariable Long id) {
        boolean deleted = sessaoService.excluirSessao(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Sessoes Ativas

    @GetMapping("/ativas")
    public List<SessaoModel> listarSessoesAtivas() {
        return sessaoService.listarSessoesAtivas();
    }

    @GetMapping("/numero/{numeroSessao}")
    public ResponseEntity<SessaoModel> buscarSesaoAtivaPorNumero(@PathVariable int numeroSessao){
        Optional<SessaoModel> sessao = sessaoService.buscarSessaoAtivaPoNumero(numeroSessao);
        return sessao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/ativas/filme/{filmeId}")
    public List<SessaoModel> listarSessoesAtivasPorFilme(@PathVariable Long filmeId) {
        return sessaoService.listarSessoesAtivasPorFilme(filmeId);
    }

    @PutMapping("/{id}/desativar")
    public SessaoModel desativarSessao(@PathVariable Long id) {
        return sessaoService.desativarSessao(id);
    }

}
