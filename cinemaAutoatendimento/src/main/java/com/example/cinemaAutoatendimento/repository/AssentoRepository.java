package com.example.cinemaAutoatendimento.repository;

import com.example.cinemaAutoatendimento.model.AssentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssentoRepository extends JpaRepository<AssentoModel, Integer> {
}
