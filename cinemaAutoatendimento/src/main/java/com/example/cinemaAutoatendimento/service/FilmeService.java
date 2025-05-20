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

    public FilmeModel atualizarFilme(Long id, FilmeModel filmeAtualizado){
        Optional<FilmeModel> filmeExistente = filmeRepository.findById(id);
        if (filmeExistente.isPresent()){
            FilmeModel filme = filmeExistente.get();
            filme.setNome(filmeAtualizado.getNome());
            filme.setData_inicio(filmeAtualizado.getData_inicio());
            filme.setData_fim(filmeAtualizado.getData_fim());

            return filmeRepository.save(filme);
        }
        return null;
    }

    public List<FilmeModel> listarFilmes(){
        return filmeRepository.findAll();
    }

    public Optional<FilmeModel> acharFilmePorId(Long id){
        return filmeRepository.findById(id);
    }

    public boolean excluirFilme(Long id){
        if (filmeRepository.existsById(id)){
            filmeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
