/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.persistencia;
import br.edu.ifpb.shared.entidades.Candidato;
import br.edu.ifpb.shared.entidades.Funcionario;
import br.edu.ifpb.shared.entidades.Pessoa;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
        return em.createQuery("Select p from Pessoa p order by Nome;", Funcionario.class).getResultList();
    }
    
    
    public void remove(long id) {
            Funcionario f = findById(id);
            em.remove(f);
    }
    
    
    
    public void update(Funcionario obj) {
            obj = em.merge(obj);
    }

    public Funcionario findByEmail(String email) {
        try {
            TypedQuery<Funcionario> tq = em.createQuery("Select f from Pessoa f where f.email =:email ", Funcionario.class);
            tq.setParameter("email", email);
            return tq.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }
    
}
