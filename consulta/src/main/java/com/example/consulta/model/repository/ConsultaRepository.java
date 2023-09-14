package com.example.consulta.model.repository;

import com.example.consulta.model.entity.Consulta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsultaRepository {
    @PersistenceContext

    private EntityManager em;

    public void save(Consulta consulta) {
        em.persist(consulta);
    }

    public Consulta consulta(Long id) {
        return em.find(Consulta.class, id);
    }

    public List<Consulta> consultas() {
        Query query = em.createQuery("from Consulta");
        return query.getResultList();
    }

    public void update(Consulta consulta) {
        em.merge(consulta);
    }
}
