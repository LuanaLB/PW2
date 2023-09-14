package com.example.consulta.model.repository;

import com.example.consulta.model.entity.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicoRepository {
    @PersistenceContext

    private EntityManager em;

    public void save(Medico medico) {
        em.persist(medico);
    }

    public Medico medico(Long id) {
        return em.find(Medico.class, id);
    }

    public List<Medico> medicos() {
        Query query = em.createQuery("from Medico");
        return query.getResultList();
    }

    public void update(Medico medico) {
        em.merge(medico);
    }
}
