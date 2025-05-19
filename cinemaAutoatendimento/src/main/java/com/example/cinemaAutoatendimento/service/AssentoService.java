package com.example.cinemaAutoatendimento.service;

import com.example.cinemaAutoatendimento.model.AssentoModel;
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

    public AssentoModel salvarAssento(AssentoModel assento) {
        SessaoModel sessao = sessaoRepository.findById(assento.getSessao().getId())
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
        assento.setSessao(sessao);

        return assentoRepository.save(assento);
    }


    public List<AssentoModel> listarAssentosPorSessao(int sessaoId){
        return assentoRepository.findBySessaoId(sessaoId);
    }

    public List<AssentoModel> listarAssentosLivresPorSessao(int sessaoId){
        return assentoRepository.findBySessaoIdAndOcupadoFalse(sessaoId);
    }

    public AssentoModel ocuparAssento(int id){
        Optional<AssentoModel> assento = assentoRepository.findById(id);
        if (assento.isPresent()) {
            AssentoModel assentoOcupado = assento.get();
            assentoOcupado.setOcupado(true);
            return assentoRepository.save(assentoOcupado);
        }
        return null;
    }

    public AssentoModel desocuparAssento(int id) {
        Optional<AssentoModel> assento = assentoRepository.findById(id);
        if (assento.isPresent()) {
            AssentoModel assentoDesocupado = assento.get();
            assentoDesocupado.setOcupado(false);
            return assentoRepository.save(assentoDesocupado);
        }
        return null;
    }

    public boolean excluirAssento(int id){
        if (assentoRepository.existsById(id)){
            assentoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
