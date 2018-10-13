/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.controle;

import br.edu.ifpb.core.services.AvaliacaoService;
import br.edu.ifpb.shared.entidades.Avaliacao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author laerton
 */
@SessionScoped
@Named
public class AvaliacaoControle implements Serializable{
    @Inject
    private AvaliacaoService service;
    private Avaliacao avaliacao = new Avaliacao();

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    public String save(){
        service.save(avaliacao);
        avaliacao = new Avaliacao();
        return null;
    }
    
    public String remove(){
        service.remove(avaliacao.getId());
        avaliacao = new Avaliacao();
        return null;
    }
    
    public List<Avaliacao> all(){
        return service.findAll();
                
    }
    
    public String findById(int id){
        avaliacao = service.findById(id);
        return null;
    }
    
}
