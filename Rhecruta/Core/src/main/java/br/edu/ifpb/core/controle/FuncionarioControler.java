/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.controle;

import br.edu.ifpb.core.services.FuncionarioService;
import br.edu.ifpb.shared.entidades.Funcionario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author laerton
 */
@SessionScoped
@Named
public class FuncionarioControler implements Serializable{
    @Inject
    private FuncionarioService service;
    private Funcionario funcionario = new Funcionario();

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public String save(){
        service.save(funcionario);
        funcionario = new Funcionario();
        return null;
    }
    
    public String remove(){
        service.remove(funcionario.getId());
        funcionario = new Funcionario();
        return null;
    }
    
    public List<Funcionario> all(){
        return service.findAll();
    }
    
    public String findById(int id){
        funcionario = service.findById(id);
        if (funcionario == null){
            funcionario = new Funcionario();
        }
        return null;
    }
   
}
