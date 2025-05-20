package com.example.cinemaAutoatendimento.repository;

import com.example.cinemaAutoatendimento.model.AssentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssentoRepository extends JpaRepository<AssentoModel, Integer> {
    List<AssentoModel> findBySessaoId(int sessaoId);
    List<AssentoModel> findBySessaoIdAndPessoaIsNull(int sessoId);
}
