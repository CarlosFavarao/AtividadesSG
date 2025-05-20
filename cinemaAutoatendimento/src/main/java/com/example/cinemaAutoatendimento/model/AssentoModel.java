package com.example.cinemaAutoatendimento.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "assentos")
@Getter
public class AssentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private int fileira;

    @Setter
    @Column(nullable = false)
    private int numero;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_sessao", nullable = false)
    private SessaoModel sessao;

    @Setter
    @ManyToOne
    @JoinColumn(name ="id_pessoa")
    private PessoaModel pessoa;

    public AssentoModel() {}

    public AssentoModel(int fileira, int numero, SessaoModel sessao, PessoaModel pessoa){
        this.fileira = fileira;
        this.numero = numero;
        this.sessao = sessao;
        this.pessoa = pessoa;
    }
}
