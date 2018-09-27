/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.persistencia;

import br.edu.ifpb.shared.entidades.Candidato;
import br.edu.ifpb.shared.interfaces.IDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Classe encarregada na ersistencia dos dados de um candidato no banco de dados
 * @author laerton
 */
public class DAOCandidato implements IDAO<Candidato>{
    private EntityManager em;

    public DAOCandidato(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Candidato obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Candidato findById(long id) {
        return em.find(Candidato.class, id);
    }

    @Override
    public List<Candidato> findAll() {
        return em.createQuery("Select * from Pessoa order by Nome;", Candidato.class).getResultList();
    }

    @Override
    public void remove(long id) {
        Candidato c = findById(id);
        try {
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        } 
        catch (Exception e) 
        {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Candidato obj) {
        try {
            em.getTransaction().begin();
            obj = em.merge(obj);
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
}
