package com.example.consulta.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Medico implements Serializable {
    @Id
    @GeneratedValue
    int id;
    private String nomeMedi;
    private String crm;
    private Consulta consulta;

    public String getNomeMedi() {
        return nomeMedi;
    }

    public void setNomeMedi(String nomeMedi) {
        this.nomeMedi = nomeMedi;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    String dadosMedi(){
        return "\nNome Medico(a): " + nomeMedi +
                "\nCRM: " + crm;
    }

    String consultasMedi(){
        return consulta.dadosConsul();
    }
}
