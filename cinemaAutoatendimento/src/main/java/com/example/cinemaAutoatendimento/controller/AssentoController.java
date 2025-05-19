package com.example.cinemaAutoatendimento.controller;

import com.example.cinemaAutoatendimento.model.AssentoModel;
import com.example.cinemaAutoatendimento.service.AssentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assentos")
public class AssentoController {

    @Autowired
    private AssentoService assentoService;

    //vou colocar só por sessão, não tem sentido algum listar assentos aleatórios de todas as sessões...
    @GetMapping("/sessao/{sessaoId}")
    public List<AssentoModel> listarAssentosPorSessao(@PathVariable int sessaoId){
        return assentoService.listarAssentosPorSessao(sessaoId);
    }

    //busca apenas os livres por sessão
    @GetMapping("/livres/sessao/{sessaoId}")
    public List<AssentoModel> listarAssentosLivresPorSessao(@PathVariable int sessaoId){
        return assentoService.listarAssentosLivresPorSessao(sessaoId);
    }

    @PostMapping("/ocupar/{id}")
    public AssentoModel ocuparAssento(@PathVariable int id){
        return assentoService.ocuparAssento(id);
    }

    @PutMapping("/desocupar/{id}")
    public AssentoModel desocuparAssento(@PathVariable int id){
        return assentoService.desocuparAssento(id);
    }
}
