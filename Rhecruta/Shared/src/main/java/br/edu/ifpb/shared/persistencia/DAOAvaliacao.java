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
import javax.persistence.Query;

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
        return em.createQuery("Select a from Avaliacao a order by a.id", Avaliacao.class).getResultList();
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
    
    /***
     * Busca por Avaliações feitas por um determinado candidato
     * @param idCandidato = Id do candidato a ser filtrado 
     * @return Lista de avaliações
     */
    public List<Avaliacao> findAvaliacaoByCandidato(int idCandidato)
    {
        Query q = em.createQuery("Select a from Avaliacao a, Candidato c Where c MEMBER OF a.candidato and c.id =: id ", Avaliacao.class);
        q.setParameter("id", idCandidato);
        return q.getResultList();
        
    }
    /***
     * Busca por avaliações avaliadas por um determinado Avaliador
     * @param idAvaliador = Id do avaliador
     * @return Lista de avaliaçãoes
     */
    public List<Avaliacao> findAvaliacaoByAvaliador(int idAvaliador){
        Query q = em.createQuery("Select a from Avaliacao a, Funcionario f Where f MEMBER OF a.avaliador and f.id =: id ", Avaliacao.class);
        q.setParameter("id", idAvaliador);
        return q.getResultList();
    }
    
    
    
    
    
}
