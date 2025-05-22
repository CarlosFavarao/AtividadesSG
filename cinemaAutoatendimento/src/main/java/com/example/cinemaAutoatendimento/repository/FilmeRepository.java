package com.example.cinemaAutoatendimento.repository;

import com.example.cinemaAutoatendimento.model.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeModel, Long> {
    @Query("SELECT f FROM FilmeModel f WHERE f.dataInicio <= CURRENT_DATE AND f.dataFim >= CURRENT_DATE")
    List<FilmeModel> findFilmesEmCartazHoje(); //Faz com que o BD faça a busca, minimizando o gasto de memória
}                                              //Tira a necessidade de baixar todo o BD para realizar o filtro     
