package com.example.Clinica.model.repository;

import com.example.Clinica.model.entity.Consulta;
import com.example.Clinica.model.entity.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsultaRepository {
    @PersistenceContext
    private EntityManager em;

    public Consulta consulta(Long id){
        return em.find(Consulta.class, id);
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
    public List<Consulta> consultas(){
        Query query = em.createQuery("from Consulta");
        return query.getResultList();
    }
    public List<Consulta> consultasMedico(Long medicoId){
        Query query = em.createQuery("FROM Consulta c WHERE c.medico.id="+medicoId);
        return query.getResultList();
    }
    public List<Consulta> consultasPaciente(Long pacienteId){
        Query query = em.createQuery("FROM Consulta c WHERE c.paciente.id ="+pacienteId);
        return query.getResultList();
    }

}

