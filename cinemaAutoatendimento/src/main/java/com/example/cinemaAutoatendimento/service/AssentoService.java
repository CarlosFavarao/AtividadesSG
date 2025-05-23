package com.example.cinemaAutoatendimento.service;

import com.example.cinemaAutoatendimento.model.AssentoModel;
import com.example.cinemaAutoatendimento.model.PessoaModel;
import com.example.cinemaAutoatendimento.model.SessaoModel;
import com.example.cinemaAutoatendimento.repository.AssentoRepository;
import com.example.cinemaAutoatendimento.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssentoService {
    @Autowired
    private AssentoRepository assentoRepository;

    @Autowired
    SessaoRepository sessaoRepository;

    public AssentoModel salvarAssento(Long id, AssentoModel assento) {
        SessaoModel sessao = sessaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

        assento.setSessao(sessao);
        return assentoRepository.save(assento);
    }

    public List<AssentoModel> listarAssentosPorSessao(Long sessaoId){
        return assentoRepository.findBySessaoId(sessaoId);
    }

    public List<AssentoModel> listarAssentosLivresPorSessao(Long sessaoId){
        return assentoRepository.findBySessaoIdAndPessoaIsNull(sessaoId);
    }

    public AssentoModel ocuparAssento(Long id, PessoaModel pessoa){
        AssentoModel assento = assentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Assento não encontrado"));
        assento.setPessoa(pessoa);

        return  assentoRepository.save(assento);
    }

    public AssentoModel desocuparAssento(Long id) {
        AssentoModel assento = assentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Assento não encontrado"));
        assento.setPessoa(null);

        return  assentoRepository.save(assento);
    }

    public boolean excluirAssento(Long id){
        if (assentoRepository.existsById(id)){
            assentoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
