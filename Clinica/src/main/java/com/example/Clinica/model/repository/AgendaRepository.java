package com.example.Clinica.model.repository;

import com.example.Clinica.model.entity.Agenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgendaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Agenda> agendas() {
        Query query = em.createQuery("from Agenda");
        return query.getResultList();
    }

    public void save(Agenda agenda){
        em.persist(agenda);
    }

    public void remove(Long id){
        Agenda m = em.find(Agenda.class, id);
        em.remove(m);
    }

    public void update(Agenda agenda){
        em.merge(agenda);
    }
    public Agenda agenda(Long id){
        return em.find(Agenda.class, id);
    }

    public List <Agenda> agendasDeMedico(Long medicoId) {
        Query query = em.createQuery("FROM Agenda c WHERE c.medico.id="+medicoId);
        return query.getResultList();
    }
}