/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.persistencia;
import br.edu.ifpb.shared.entidades.Funcionario;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author laerton
 */
@Singleton
public class DAOFuncionario {
    @PersistenceContext
    private EntityManager em;

    public DAOFuncionario() {
    }
    
    public void save(Funcionario obj) {
            em.persist(obj);
    }

    
    public Funcionario findById(long id) {
        return em.find(Funcionario.class, id);
    }
    
    public List<Funcionario> findAll() {
        return em.createQuery("Select * from Pessoa order by Nome;", Funcionario.class).getResultList();
    }
    
    
    public void remove(long id) {
            Funcionario f = findById(id);
            em.remove(f);
    }
    
    
    
    public void update(Funcionario obj) {
            obj = em.merge(obj);
    }
    
}
