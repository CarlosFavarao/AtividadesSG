package com.example.cinemaAutoatendimento.repository;

import com.example.cinemaAutoatendimento.model.SessaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoModel, Integer> {
    List<SessaoModel> findByFilmeId(int filmeId);
}
