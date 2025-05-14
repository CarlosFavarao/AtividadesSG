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
    private int id;

    @Setter
    @Column(nullable = false)
    private String nome;

    @Setter
    @Column(nullable = false)
    private LocalDate data_inicio;

    @Setter
    @Column(nullable = false)
    private LocalDate data_fim;

    public FilmeModel() {} //Construtor padrão, não lembrava dele. Porém, é essencial pra o funcionamento do JPA

    public FilmeModel(LocalDate data_fim, String nome, LocalDate data_inicio) {
        this.data_fim = data_fim;
        this.nome = nome;
        this.data_inicio = data_inicio;
    }
}