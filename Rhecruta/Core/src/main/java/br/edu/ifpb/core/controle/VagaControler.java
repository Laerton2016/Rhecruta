/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.controle;

import br.edu.ifpb.core.services.VagaService;
import br.edu.ifpb.shared.entidades.Vaga;
import br.edu.ifpb.shared.entidades.VagaFull;
import java.io.Serializable;
import java.util.LinkedList;
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
    private List<VagaFull> vagasWeb = new LinkedList<>();
    private String tipo = "";
    private String termo = "";

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    public Vaga getVaga() {
        return vaga;
    }
    
    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public List<VagaFull> getVagasWeb() {
        return vagasWeb;
    }

    public void setVagasWeb(List<VagaFull> vagasWeb) {
        this.vagasWeb = vagasWeb;
    }
    
    public String save(){
        service.saveVagaBanco(vaga);
        vaga = new Vaga();
        return null;
    }
    public String editar(Vaga vaga){
        this.vaga = vaga;
        return null;
    }
    
    public String remove (Vaga vaga){
        service.removeVagaDoBanco(vaga.getId());
        this.vaga = new Vaga();
        return null;
    }
    
    public List<Vaga> findVagasBanco(){
        return service.findAllVagasBanco();
    }
    
    public String findVagasWeb(){
        vagasWeb = service.findVagasWeb();
        return null;
    }
    
    public String limpar(){
        vagasWeb = new LinkedList<>();
        return null;
    }
    
    public String findVagasWebTermo(){
        if (termo.trim().equals("")||tipo.trim().equals("")){
            findVagasWeb();
        }else if (tipo.equals("Cidade")){
            vagasWeb = service.findByCidade(termo);
        }else if (tipo.equals("Empresa")){
            vagasWeb = service.findByEmpresa(termo);
        }else{
            vagasWeb = service.findByDescricao(termo);
        }
        termo = "";
        return null;
    }
    
    public String findById(int id){
        vaga = service.findVagaBancoById(id);
        if (vaga == null){
            vaga = new Vaga();
        }
        return null;
    }
    
    
}
