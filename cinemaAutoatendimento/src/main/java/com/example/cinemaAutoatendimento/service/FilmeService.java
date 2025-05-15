package com.example.cinemaAutoatendimento.service;

import com.example.cinemaAutoatendimento.model.FilmeModel;
import com.example.cinemaAutoatendimento.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public FilmeModel salvarFilme(FilmeModel filme){
        return filmeRepository.save(filme);
    }

    public List<FilmeModel> listarFilmes(){
        return filmeRepository.findAll();
    }

    public Optional<FilmeModel> acharFilmePorId(int id){
        return filmeRepository.findById(id);
    }

    public void excluirFilme(int id){
        filmeRepository.deleteById(id);
    }
}
