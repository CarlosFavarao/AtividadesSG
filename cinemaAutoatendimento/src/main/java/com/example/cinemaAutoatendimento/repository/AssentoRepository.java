package com.example.cinemaAutoatendimento.repository;

import com.example.cinemaAutoatendimento.model.AssentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssentoRepository extends JpaRepository<AssentoModel, Long> {
    List<AssentoModel> findBySessaoId(Long sessaoId);
    List<AssentoModel> findBySessaoIdAndPessoaIsNull(Long sessoId);
    boolean existsBySessaoIdAndPessoaIsNotNull(Long sessaoId);
}
