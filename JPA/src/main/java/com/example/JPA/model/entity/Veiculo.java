package com.example.JPA.model.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String marca;
    private Long anoFabricacao;
    private String placa;

    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public Long getAnoFabricacao() { return anoFabricacao; }

    public void setAnoFabricacao(Long anoFabricacao) { this.anoFabricacao = anoFabricacao; }

    public String getPlaca() { return placa; }

    public void setPlaca(String placa) { this.placa = placa; }
}