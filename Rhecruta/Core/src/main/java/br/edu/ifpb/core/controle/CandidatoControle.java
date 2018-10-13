/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.controle;

import br.edu.ifpb.core.services.CandidatoService;
import br.edu.ifpb.shared.entidades.Candidato;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author laerton
 */
@Named
@SessionScoped
public class CandidatoControle implements Serializable{
    @Inject
    private CandidatoService service;
    
    private Candidato candidato = new Candidato();

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public List<Candidato> all(){
        return service.findAll();
    }
    
    public String findById(int id){
        candidato = service.findById(id);
        if (candidato == null){
            candidato = new Candidato();
        }
        return null;
    }
    
    public String save (){
        service.save(candidato);
        candidato = new Candidato();
        return null;
    }
    
    public String remove(){
        service.remove(candidato.getId());
        candidato = new Candidato();
        return null;
    }
}
