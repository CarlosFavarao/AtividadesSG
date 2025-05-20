package com.example.cinemaAutoatendimento.controller;

import com.example.cinemaAutoatendimento.model.FilmeModel;
import com.example.cinemaAutoatendimento.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @PostMapping
    public FilmeModel salvarFilme(@RequestBody FilmeModel filme){
        return filmeService.salvarFilme(filme);
    }

    @PutMapping("/{id}")
    public FilmeModel atualizarFilme(@PathVariable Long id, @RequestBody FilmeModel filmeAtualizado){
        return filmeService.atualizarFilme(id, filmeAtualizado);
    }

    @GetMapping
    public List<FilmeModel> listarFilmes(){
        return filmeService.listarFilmes();
    }

    @GetMapping("/filme/{id}")
    public Optional<FilmeModel> buscarFilmePorId(@PathVariable Long id){
        return filmeService.acharFilmePorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFilme(@PathVariable Long id) {
        boolean deleted = filmeService.excluirFilme(id);
        if (deleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
