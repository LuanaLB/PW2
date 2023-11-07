package com.consulta.consulta.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.consulta.consulta.model.entity.Consulta;
import com.consulta.consulta.model.entity.Medico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class MedicoRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Medico> medicos() {
        Query query = em.createQuery("from Medico");
        return query.getResultList();
    }

    public void save(Medico medico){
        em.persist(medico);
    }
    public void remove(Long id){
        Medico m = em.find(Medico.class, id);
        em.remove(m);
    }

    public void update(Medico medico){
        em.merge(medico);
    }

    public Medico medico(Long id){
        return em.find(Medico.class, id);
    }
}
