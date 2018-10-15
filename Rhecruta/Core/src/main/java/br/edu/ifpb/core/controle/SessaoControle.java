/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.controle;

import br.edu.ifpb.core.services.CandidatoService;
import br.edu.ifpb.core.services.FuncionarioService;
import br.edu.ifpb.shared.entidades.Candidato;
import br.edu.ifpb.shared.entidades.Funcionario;
import br.edu.ifpb.shared.entidades.Pessoa;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author laerton
 */
@Stateless
@Named
public class SessaoControle implements Serializable{
    
    private Pessoa pessoa = new Pessoa();
    private String email ="";
    private String tipo = "";
    
    @Inject
    private CandidatoService serviceCandidato;
    @Inject
    private FuncionarioService serviceFuncionario;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public void setFuncionario(Funcionario funcionario){
        pessoa = funcionario;
    }
    public Funcionario getFuncionario(){
        return (Funcionario) pessoa;
    }
    
    public String acessaFuncionario(FuncionarioControler fun, CandidatoControle can){
        if (tipo.equals("0")){
            fun.setFuncionario((Funcionario)pessoa);
            can.setCandidato(new Candidato());
            return "../../Core/faces/funcionario.xhtml";
        }
        return null;
    }
    public String acessaCandidato(CandidatoControle can, FuncionarioControler fun)
    {
        if (tipo.equals("1")){
            can.setCandidato((Candidato)pessoa);
            fun.setFuncionario(new Funcionario());
            return "../../Core/faces/canidato.xhtml";
        }
        return "../../Core/faces/canidato.xhtml";
    }
    public void setCandidato(Candidato candidato){
        pessoa = candidato;
    }
    
    public Candidato getCandidato(){
        return (Candidato) pessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String log(){
        Pessoa p = null ;
        if (!email.equals("")){
            try {
                if (tipo.equals("0")){
                p = serviceFuncionario.findByEmail(email);
                
            }else{
                p = serviceCandidato.findByEmail(email);
            }
            } catch (Exception e) {
                pessoa = new Pessoa();
                return null;
            }
        }
        if (p != null){
            pessoa= p;
        }else{
            pessoa = new Pessoa();
        }
        return null;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
