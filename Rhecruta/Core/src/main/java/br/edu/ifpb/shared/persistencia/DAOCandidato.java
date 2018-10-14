/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.persistencia;

import br.edu.ifpb.shared.entidades.Candidato;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    
    
}
