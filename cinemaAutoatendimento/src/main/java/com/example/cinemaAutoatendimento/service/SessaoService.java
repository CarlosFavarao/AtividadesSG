package com.example.cinemaAutoatendimento.service;

import com.example.cinemaAutoatendimento.model.SessaoModel;
import com.example.cinemaAutoatendimento.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    public SessaoModel salvarSessao(SessaoModel sessao){
        return sessaoRepository.save(sessao);
    }

    public List<SessaoModel> listarSessoesPorFilme(int filmeId){
        return sessaoRepository.findByFilmeId(filmeId);
    }
}
