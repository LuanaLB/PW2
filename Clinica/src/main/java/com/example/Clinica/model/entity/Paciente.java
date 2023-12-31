package com.example.Clinica.model.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@DiscriminatorValue("P")
public class Paciente extends Pessoa{
    @NotBlank
    private String telefone;
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

}