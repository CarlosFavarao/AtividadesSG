package com.example.cinemaAutoatendimento.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "sessao")
@Getter
public class SessaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(nullable = false)
    private int numero_sessao;

    @Setter
    @Column(nullable = false)
    private LocalTime horario_inicio;

    @Setter
    @Column(nullable = false)
    private LocalTime horario_fim;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_filme", nullable = false)
    private FilmeModel filme;

    public SessaoModel() {}

    public SessaoModel(FilmeModel filme, LocalTime horario_fim, LocalTime horario_inicio, int numero_sessao) {
        this.filme = filme;
        this.horario_fim = horario_fim;
        this.horario_inicio = horario_inicio;
        this.numero_sessao = numero_sessao;
    }
}
