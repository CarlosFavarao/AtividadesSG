package com.example.cinemaAutoatendimento.repository;

import com.example.cinemaAutoatendimento.model.SessaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoModel, Integer> {
    //Os nomes são autoexplicativos
    List<SessaoModel> findByFilmeId(int filmeId);
    List<SessaoModel> findByAtivaTrue();
    List<SessaoModel> findByFilmeIdAndAtivaTrue(int filmeId);
    Optional<SessaoModel> findByNumeroSessaoAndAtivaTrue(int numeroSessao);
}
