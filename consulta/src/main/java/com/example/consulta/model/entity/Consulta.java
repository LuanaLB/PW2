package com.example.consulta.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Consulta implements Serializable {
    @Id
    @GeneratedValue
    int id;
    LocalDateTime data;
    double valor;
    String descricao;
    Paciente paciente;
    Medico medico;

    public LocalDateTime getData() { return data; }

    public void setData(LocalDateTime data) { this.data = data; }

    public double getValor() { return valor; }

    public void setValor(double valor) { this.valor = valor; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    String dadosConsul() {
        return paciente.dadosPacie() + medico.dadosMedi() +
                "\nData da consulta: " + data +
               "\nValor: " + valor +
               "\nDescrição " + descricao;
    }

    @OneToMany(mappedBy = "consulta")
    private List<Paciente> pacientes;
}