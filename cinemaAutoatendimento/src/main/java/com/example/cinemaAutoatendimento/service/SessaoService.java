package com.example.cinemaAutoatendimento.service;

import com.example.cinemaAutoatendimento.model.SessaoModel;
import com.example.cinemaAutoatendimento.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    public SessaoModel salvarSessao(SessaoModel sessao){
        return sessaoRepository.save(sessao);
    }

    public SessaoModel atualizarSessao(int id, SessaoModel sessaoAtualizada) {
        Optional<SessaoModel> sessaoExistente = sessaoRepository.findById(id);
        if (sessaoExistente.isPresent()) {
            SessaoModel sessao = sessaoExistente.get();
            sessao.setNumero_sessao(sessaoAtualizada.getNumero_sessao());
            sessao.setHorario_inicio(sessaoAtualizada.getHorario_inicio());
            sessao.setHorario_fim(sessaoAtualizada.getHorario_fim());
            sessao.setFilme(sessaoAtualizada.getFilme());
            return sessaoRepository.save(sessao);
        }
        return null;
    }

    public List<SessaoModel> listarSessoesPorFilme(int filmeId){
        return sessaoRepository.findByFilmeId(filmeId);
    }

    public Optional<SessaoModel> acharSessaoPorId(int id){
        return sessaoRepository.findById(id);
    }

    public boolean excluirSessao(int id) {
        if (sessaoRepository.existsById(id)){
            sessaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
