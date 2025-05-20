package com.example.cinemaAutoatendimento.repository;

import com.example.cinemaAutoatendimento.model.SessaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoModel, Long> {
    //Os nomes são autoexplicativos
    List<SessaoModel> findByFilmeId(Long filmeId);
    List<SessaoModel> findByAtivaTrue();
    List<SessaoModel> findByFilmeIdAndAtivaTrue(Long filmeId);
    Optional<SessaoModel> findByNumeroSessaoAndAtivaTrue(int numeroSessao);
}
