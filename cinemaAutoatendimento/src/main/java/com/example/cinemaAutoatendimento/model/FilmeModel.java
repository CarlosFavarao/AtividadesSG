package com.example.cinemaAutoatendimento.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "filme")
@Getter
public class FilmeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String nome;

    @Setter
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Setter
    @Column(name = "dataFim", nullable = false)
    private LocalDate dataFim;

    public FilmeModel() {} //Construtor padrão, não lembrava dele. Porém, é essencial pra o funcionamento do JPA

    public FilmeModel(LocalDate dataFim, String nome, LocalDate dataInicio) {
        this.dataFim = dataFim;
        this.nome = nome;
        this.dataInicio = dataInicio;
    }
}