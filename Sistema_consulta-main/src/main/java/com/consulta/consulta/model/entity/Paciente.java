package com.consulta.consulta.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("P")
public class Paciente extends Pessoa{
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
