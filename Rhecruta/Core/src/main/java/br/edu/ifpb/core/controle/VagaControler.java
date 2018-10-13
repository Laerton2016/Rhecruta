/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.controle;

import br.edu.ifpb.core.services.VagaService;
import br.edu.ifpb.shared.entidades.Vaga;
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
public class VagaControler implements Serializable{
    @Inject
    private VagaService service;
    private Vaga vaga = new Vaga();
    private Vaga vagaApi = new Vaga();
    
    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
    
    public String save(){
        service.saveVagaBanco(vaga);
        vaga = new Vaga();
        return null;
    }
    
    public String remove (){
        service.removeVagaDoBanco(vaga.getId());
        vaga = new Vaga();
        return null;
    }
    
    public List<Vaga> findVagasBanco(){
        return service.findAllVagasBanco();
    }
    
    public List<Vaga> findVagasWeb(){
        return service.findVagasWeb();
    }
    
    public String findById(int id){
        vaga = service.findVagaBancoById(id);
        if (vaga == null){
            vaga = new Vaga();
        }
        return null;
    }
    
}
