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

    public SessaoModel salvarSessao(SessaoModel novaSessao){ //Isso vai desativar qualquer sessão com o mesmo numero
        SessaoModel sessaoAtivaExiste = sessaoRepository.findByNumeroSessaoAndAtivaTrue(novaSessao.getNumero_sessao()).orElse(null);

        if (sessaoAtivaExiste != null){
            sessaoAtivaExiste.setAtiva(false);
            sessaoRepository.save(sessaoAtivaExiste);
        }

        return sessaoRepository.save(novaSessao);
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

    //Com todas as Sessoes
    public List<SessaoModel> listarSessoes(){
        return sessaoRepository.findAll();
    }

    public List<SessaoModel> listarSessoesPorFilme(int filmeId){
        return sessaoRepository.findByFilmeId(filmeId);
    }

    public Optional<SessaoModel> acharSessaoPorId(int id){
        return sessaoRepository.findById(id);
    }

    //Deletar...
    public boolean excluirSessao(int id) {
        if (sessaoRepository.existsById(id)){
            sessaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Apenas Sessoes ativas
    public List<SessaoModel> listarSessoesAtivas() {
        return sessaoRepository.findByAtivaTrue();
    }

    public List<SessaoModel> listarSessoesAtivasPorFilme(int filmeId) {
        return sessaoRepository.findByFilmeIdAndAtivaTrue(filmeId);
    }

    public Optional<SessaoModel> buscarSessaoAtivaPoNumero(int numeroSessao){
        return sessaoRepository.findByNumeroSessaoAndAtivaTrue(numeroSessao);
    }

    public SessaoModel desativarSessao(int id) {
        Optional<SessaoModel> sessao = sessaoRepository.findById(id);
        if (sessao.isPresent()) {
            SessaoModel s = sessao.get();
            s.setAtiva(false);
            return sessaoRepository.save(s);
        }
        return null;
    }
}
