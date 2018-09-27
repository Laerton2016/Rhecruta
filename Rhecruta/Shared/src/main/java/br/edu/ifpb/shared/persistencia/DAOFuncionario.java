/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.persistencia;
import br.edu.ifpb.shared.entidades.Funcionario;
import br.edu.ifpb.shared.interfaces.IDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author laerton
 */
public class DAOFuncionario implements IDAO<Funcionario>{
    private EntityManager em;

    public DAOFuncionario(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public void save(Funcionario obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Funcionario findById(long id) {
        return em.find(Funcionario.class, id);
    }
    @Override
    public List<Funcionario> findAll() {
        return em.createQuery("Select * from Pessoa order by Nome;", Funcionario.class).getResultList();
    }
    
    @Override
    public void remove(long id) {
        try {
            Funcionario f = findById(id);
            em.getTransaction().begin();
            em.remove(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    
    @Override
    public void update(Funcionario obj) {
        try {
            obj = em.merge(obj);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
}
