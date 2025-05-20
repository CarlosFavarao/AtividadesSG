package com.example.cinemaAutoatendimento.repository;

import com.example.cinemaAutoatendimento.model.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeModel, Long> {
}
