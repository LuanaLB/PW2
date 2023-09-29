package com.example.mapHeranca.model.repository;

import com.example.mapHeranca.model.entity.Consulta;
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
    public List<Consulta> consultas(){
        Query query = em.createQuery("from Consulta");
        return query.getResultList();
    }
    public List<Consulta> consultasMedico(Long id){
        Query query = em.createQuery("from Consulta c where c.medico.id = " + id);
        return query.getResultList();
    }
    public List<Consulta> consultasPaciente(Long id){
        Query query = em.createQuery("from Consulta c where c.paciente.id = "+ id);
        return query.getResultList();
    }
}
