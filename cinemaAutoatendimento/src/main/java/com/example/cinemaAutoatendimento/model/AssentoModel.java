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
    private int id;

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
    @Column
    private boolean ocupado;

    public AssentoModel() {}

    public AssentoModel(int fileira, int numero, SessaoModel sessao, boolean ocupado){
        this.fileira = fileira;
        this.numero = numero;
        this.sessao = sessao;
        this.ocupado = ocupado;
    }
}
