package com.example.cinemaAutoatendimento.service;

import com.example.cinemaAutoatendimento.model.FilmeModel;
import com.example.cinemaAutoatendimento.model.SessaoModel;
import com.example.cinemaAutoatendimento.repository.AssentoRepository;
import com.example.cinemaAutoatendimento.repository.FilmeRepository;
import com.example.cinemaAutoatendimento.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AssentoRepository assentoRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    public FilmeModel salvarFilme(FilmeModel filme){
        return filmeRepository.save(filme);
    }

    public FilmeModel atualizarFilme(Long id, FilmeModel filmeAtualizado){
        Optional<FilmeModel> filmeExistente = filmeRepository.findById(id);
        if (filmeExistente.isPresent()){
            FilmeModel filme = filmeExistente.get();
            filme.setNome(filmeAtualizado.getNome());
            filme.setDataInicio(filmeAtualizado.getDataInicio());
            filme.setDataFim(filmeAtualizado.getDataFim());

            return filmeRepository.save(filme);
        }
        return null;
    }

    public List<FilmeModel> listarFilmes(){
        return filmeRepository.findAll();
    }

    public List<FilmeModel> listarFilmesEmCartaz(){
        return filmeRepository.findFilmesEmCartazHoje();
    }

    public Optional<FilmeModel> acharFilmePorId(Long id){
        return filmeRepository.findById(id);
    }

    public boolean podeExcluir(Long filmeId){
        List<SessaoModel> sessoes = sessaoRepository.findByFilmeId(filmeId);

        for (SessaoModel sessao : sessoes){
            boolean temAssentoOcupado = assentoRepository.existsBySessaoIdAndPessoaIsNotNull(sessao.getId());
            if (temAssentoOcupado){
                return false;
            }
        }
        return true;
    }

    public boolean excluirFilme(Long id){
        if (!podeExcluir((id))){
            return false;
        }

        filmeRepository.deleteById(id);
        return true;
    }
}
