package com.consulta.consulta.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.consulta.consulta.model.entity.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PacienteRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Paciente> pacientes() {
        Query query = em.createQuery("from Paciente");
        return query.getResultList();
    }

    public void save(Paciente paciente){
        em.persist(paciente);
    }
    public void remove(Long id){
        Paciente p = em.find(Paciente.class, id);
        em.remove(p);
    }

    public void update(Paciente paciente){
        em.merge(paciente);
    }

    public Paciente paciente(Long id){
        return em.find(Paciente.class, id);
    }
}
