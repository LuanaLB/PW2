package com.consulta.consulta.model.repository;

import java.util.List;

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

    // Método para buscar consultas de um paciente específico pelo ID do paciente
    public List<Consulta> consultasDePaciente(Long pacienteId) {
        Query query = em.createQuery("FROM Consulta c WHERE c.paciente.id ="+pacienteId);
        //query.setParameter("pacienteId", pacienteId);
        return query.getResultList();
    }

    // Método para buscar consultas de um médico específico pelo ID do médico
    public List <Consulta> consultasDeMedico(Long medicoId) {
        Query query = em.createQuery("FROM Consulta c WHERE c.medico.id="+medicoId);
        //query.setParameter("medicoId", medicoId);
        return query.getResultList();
    }
}
