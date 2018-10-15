/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.persistencia;

import br.edu.ifpb.shared.entidades.Candidato;
import br.edu.ifpb.shared.entidades.Funcionario;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Classe encarregada na ersistencia dos dados de um candidato no banco de dados
 * @author laerton
 */
@Singleton
public class DAOCandidato {
    @PersistenceContext
    private EntityManager em;

    public DAOCandidato() {
    
    }

    public void save(Candidato obj) {
            em.persist(obj);
    }

   
    public Candidato findById(long id) {
        return em.find(Candidato.class, id);
    }

    
    public List<Candidato> findAll() {
        return em.createQuery("Select * from Pessoa order by Nome;", Candidato.class).getResultList();
    }

    
    public void remove(long id) {
        Candidato c = findById(id);
        em.remove(c);
   
    }

    
    public void update(Candidato obj) {
            obj = em.merge(obj);
   
    }

    public Candidato findByEmail(String email) {
        try {
            TypedQuery<Candidato> tq = em.createQuery("Select f from Pessoa f where f.email =:email ", Candidato.class);
            //Query q = em.createQuery("Select c from Pessoa c Where c.email =: email ", Candidato.class);
            tq.setParameter("email", email);
            return tq.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
    
}
