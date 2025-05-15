package com.example.cinemaAutoatendimento.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Getter
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(nullable = false)
    private String nome;

    public PessoaModel () {}

    public PessoaModel(String nome){
        this.nome = nome;
    }
}
