package com.consulta.consulta.model.repository;

import java.util.List;

import com.consulta.consulta.model.entity.Medico;
import com.consulta.consulta.model.entity.Paciente;
import org.springframework.stereotype.Repository;

import com.consulta.consulta.model.entity.Consulta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ConsultaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Consulta> consultas() {
        Query query = em.createQuery("from Consulta");
        return query.getResultList();
    }

    public List<Consulta> consultasDePaciente(Long pacienteId) {
        Query query = em.createQuery("FROM Consulta c WHERE c.paciente.id ="+pacienteId);
        //query.setParameter("pacienteId", pacienteId);
        return query.getResultList();
    }

    public List <Consulta> consultasDeMedico(Long medicoId) {
        Query query = em.createQuery("FROM Consulta c WHERE c.medico.id="+medicoId);
        //query.setParameter("medicoId", medicoId);
        return query.getResultList();
    }

    public void save(Consulta consulta){
        em.persist(consulta);
    }
    public void remove(Long id){
        Consulta c = em.find(Consulta.class, id);
        em.remove(c);
    }

    public void update(Consulta consulta){
        em.merge(consulta);
    }
    public Consulta consulta(Long id){
        return em.find(Consulta.class, id);
    }


}
