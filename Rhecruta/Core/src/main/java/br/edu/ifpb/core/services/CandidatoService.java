/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.services;

import br.edu.ifpb.shared.entidades.Candidato;
import br.edu.ifpb.shared.persistencia.DAOCandidato;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author laerton
 */
@Stateless
public class CandidatoService {
    @Inject
    private DAOCandidato dAOCandidato;
    
    public void save(Candidato candidato){
        if (candidato.getId() == 0){
            dAOCandidato.save(candidato);
        }else{
            dAOCandidato.update(candidato);
        }
           
    }
    
    public void remove(int idCandidato){
        dAOCandidato.remove(idCandidato);
    }
    
    public List<Candidato> findAll(){
        return dAOCandidato.findAll();
    }
    
    public Candidato findById(int id){
        return dAOCandidato.findById(id);
    }
            
}
