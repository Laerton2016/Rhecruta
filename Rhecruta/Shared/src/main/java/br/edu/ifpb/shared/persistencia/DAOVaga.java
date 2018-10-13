/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.persistencia;

import br.edu.ifpb.shared.entidades.Vaga;
import br.edu.ifpb.shared.interfaces.IDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author laerton
 */
public class DAOVaga {

    private EntityManager em ;

    public DAOVaga(EntityManager em) {
        this.em = em;
    }
    
    
    public void save(Vaga obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    
    public void update(Vaga obj) {
        try {
            obj = em.merge(obj);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    
    public Vaga findById(long id) {
        return em.find(Vaga.class, id);
    }

    
    public List<Vaga> findAll() {
        return em.createQuery("Select * from Vaga order by id", Vaga.class).getResultList();
    }

    
    public void remove(long id) {
        try {
            Vaga v = findById(id);
            em.getTransaction().begin();
            em.remove(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
}
