package com.example.Clinica.model.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@DiscriminatorValue("M")
public class Medico extends Pessoa{
    @NotBlank
    private String crm;
    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "medico")
    private  List<Agenda> agendas;

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

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

}