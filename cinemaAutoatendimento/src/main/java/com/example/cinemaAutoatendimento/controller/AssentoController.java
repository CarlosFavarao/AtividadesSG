package com.example.cinemaAutoatendimento.controller;

import com.example.cinemaAutoatendimento.model.AssentoModel;
import com.example.cinemaAutoatendimento.model.PessoaModel;
import com.example.cinemaAutoatendimento.service.AssentoService;
import com.example.cinemaAutoatendimento.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assentos")
public class AssentoController {

    @Autowired
    private AssentoService assentoService;

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/sessao/{id}")
    AssentoModel salvarAssento(@PathVariable Long id, @RequestBody AssentoModel assento){
        return assentoService.salvarAssento(id, assento);
    }

    @PutMapping("/ocupar/{id}")
    public AssentoModel ocuparAssento(@PathVariable Long id, @RequestParam Long pessoaId){
        PessoaModel pessoa = pessoaService.buscarPessoaPorId(pessoaId);
        return assentoService.ocuparAssento(id, pessoa);
    }

    @PutMapping("/desocupar/{id}")
    public AssentoModel desocuparAssento(@PathVariable Long id){
        return assentoService.desocuparAssento(id);
    }

    //vou colocar só por sessão, não tem sentido algum listar assentos aleatórios de todas as sessões...
    @GetMapping("/sessao/{sessaoId}")
    public List<AssentoModel> listarAssentosPorSessao(@PathVariable Long sessaoId){
        return assentoService.listarAssentosPorSessao(sessaoId);
    }

    //busca apenas os livres por sessão
    @GetMapping("/livres/sessao/{sessaoId}")
    public List<AssentoModel> listarAssentosLivresPorSessao(@PathVariable Long sessaoId){
        return assentoService.listarAssentosLivresPorSessao(sessaoId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAssento(@PathVariable Long id){
        boolean deleted = assentoService.excluirAssento(id);
        if (deleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
