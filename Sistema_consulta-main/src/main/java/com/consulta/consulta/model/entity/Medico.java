package com.consulta.consulta.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("M")
public class Medico extends Pessoa{
    private String crm;
    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

}
