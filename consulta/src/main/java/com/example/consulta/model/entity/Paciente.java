package com.example.consulta.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;

@Entity
public class Paciente implements Serializable {
    @Id
    @GeneratedValue
    int id;
    private String nomePacie;
    private String telefone;
    private Consulta consulta;

    public String getNomePacie() {
        return nomePacie;
    }

    public void setNomePacie(String nomePacie) {
        this.nomePacie = nomePacie;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    String dadosPacie() {
        return "\nNome paciente: " + nomePacie
                + "\nTelefone: " + telefone;
    }

   String consultasPacie() {
        return consulta.dadosConsul();
    }

}
