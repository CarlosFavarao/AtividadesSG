package com.example.cinemaAutoatendimento.service;

import com.example.cinemaAutoatendimento.model.AssentoModel;
import com.example.cinemaAutoatendimento.repository.AssentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssentoService {
    @Autowired
    private AssentoRepository assentoRepository;

    public AssentoModel salvarAssento(AssentoModel assento){
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
}
