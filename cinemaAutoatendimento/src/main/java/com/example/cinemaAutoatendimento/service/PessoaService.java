package com.example.cinemaAutoatendimento.service;

import com.example.cinemaAutoatendimento.model.PessoaModel;
import com.example.cinemaAutoatendimento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel salvarPessoa(PessoaModel pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<PessoaModel> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> buscarPessoaPorId(int id){
        return pessoaRepository.findById(id);
    }

    public boolean excluirPessoa(int id) {
        if (pessoaRepository.existsById(id)){
            pessoaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
