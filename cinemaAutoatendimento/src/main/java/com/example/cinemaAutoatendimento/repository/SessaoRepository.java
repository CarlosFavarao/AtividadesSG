package com.example.cinemaAutoatendimento.repository;

import com.example.cinemaAutoatendimento.model.SessaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoModel, Integer> {
}
