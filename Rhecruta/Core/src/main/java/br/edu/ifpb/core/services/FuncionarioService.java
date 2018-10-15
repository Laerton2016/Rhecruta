/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.services;

import br.edu.ifpb.shared.entidades.Funcionario;
import br.edu.ifpb.shared.entidades.Pessoa;
import br.edu.ifpb.shared.persistencia.DAOFuncionario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author laerton
 */
@Stateless
public class FuncionarioService {
    @Inject
    private DAOFuncionario dAOFuncionario;
    
    public void save (Funcionario funcionario){
       if (funcionario.getId()== 0) {
           dAOFuncionario.save(funcionario);
       }else{
           dAOFuncionario.update(funcionario);
       }
    }
    
    public void remove(int idFuncionario){
        dAOFuncionario.remove(idFuncionario);
    }
    
    public List<Funcionario> findAll(){
        return dAOFuncionario.findAll();
    }
    
    public Funcionario findById(int id){
        return dAOFuncionario.findById(id);
    }

    public Funcionario findByEmail(String email) {
        try {
            return dAOFuncionario.findByEmail(email);
        } catch (Exception e) {
            return null;
        }
    }
}
