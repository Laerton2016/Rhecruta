/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.persistencia;

import br.edu.ifpb.shared.entidades.Avaliacao;
import br.edu.ifpb.shared.interfaces.IDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author laerton
 */
public class DAOAvaliacao implements IDAO<Avaliacao>{

    private EntityManager em;

    public DAOAvaliacao(EntityManager em) {
        this.em = em;
    }
    
    
    @Override
    public void save(Avaliacao obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Avaliacao obj) {
        try {
            obj = em.merge(obj);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Avaliacao findById(long id) {
       return em.find(Avaliacao.class, id);
    }

    @Override
    public List<Avaliacao> findAll() {
        return em.createQuery("Select * from Avaliacao order by id", Avaliacao.class).getResultList();
    }

    @Override
    public void remove(long id) {
        try {
            Avaliacao a = findById(id);
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
}
