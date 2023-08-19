package com.example.Spring02.model.entity;

public class Pessoa {
    private Long id;
    private String descricao;
    private Long valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String nome) {
        this.descricao = nome;
    }

    public Long getValor() { return valor; }

    public void setValor(Long valor) { this.valor = valor; }
}