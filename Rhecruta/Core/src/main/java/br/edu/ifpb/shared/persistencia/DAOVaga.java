/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.persistencia;

import br.edu.ifpb.shared.entidades.Vaga;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author laerton
 */
@Singleton
public class DAOVaga {

    @PersistenceContext
    private EntityManager em ;

    public DAOVaga() {
    }
       
    public void save(Vaga obj) 
    {
            em.persist(obj);
    }

    
    public void update(Vaga obj) 
    {
            obj = em.merge(obj);
    }

    
    public Vaga findById(long id) {
        return em.find(Vaga.class, id);
    }

    
    public List<Vaga> findAll() {
        return em.createQuery("Select v from Vaga v order by v.id", Vaga.class).getResultList();
    }

    
    public void remove(long id) {
            Vaga v = findById(id);
            em.remove(v);
    }
    
    /***
     * Busca por vagas de uma determinada cidade
     * @param cidade - Cidade que será usado na busca
     * @return - Lista de vagas localizadas
     */
    public List<Vaga> findByCidade(String cidade){
        Query q = em.createQuery("Select v from Vaga v where v.cidade =:cidade order by v.id", Vaga.class);
        q.setParameter("cidade", cidade);
        return q.getResultList();
    }
    
    /***
     * Busca por vagas em uma determinada empresa
     * @param empresa - Empresa que será usada como filtro
     * @return - Lista de vagas da empresa informada
     */
    public List<Vaga> findByEmpresa(String empresa){
        Query q = em.createQuery("Select v from Vaga v where v.empresa =:empresa order by v.id", Vaga.class);
        q.setParameter("empresa", empresa);
        return q.getResultList();
    }
    
    /***
     * Lista as vagas que contem em sua descrição referencia ao termo repassado
     * @param termo - Termo a ser aplicado como filtro
     * @return - Lista de vagas localizadas pelo termo repassado
     */
    public List<Vaga> findByReferencia(String termo){
        Query q = em.createQuery("Select v from Vaga v where v.descricao like :termo order by v.id", Vaga.class);
        q.setParameter("termo","%" + termo + "%");
        return q.getResultList();
    }
    
    
}
