package com.example.JPA.model.repository;

import jakarta.persistence.EntityManager;
import com.example.JPA.model.entity.Veiculo;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class VeiculoRepository {

    @PersistenceContext
     EntityManager em;

    public void save(Veiculo veiculo){
        em.persist(veiculo);
    }

    public Veiculo veiculo(Long id){
        return em.find(Veiculo.class, id);
    }

    public List<Veiculo> veiculos(){
        Query query = em.createQuery("from Veiculo");
        return query.getResultList();
    }

    public void remove(Long id){
        Veiculo v = em.find(Veiculo.class, id);
        em.remove(v);
    }

    public void update(Veiculo veiculo){
        em.merge(veiculo);
    }
}