package com.example.Spring02.model.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Id
    private Long id;

    private String descricao;
    private Long valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Long getValor() { return valor; }

    public void setValor(Long valor) { this.valor = valor; }
}
