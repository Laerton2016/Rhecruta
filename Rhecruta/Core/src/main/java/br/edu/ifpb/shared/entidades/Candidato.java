/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.entidades;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author laerton  
 */
@Entity
public class Candidato extends Pessoa{
    private String Curriculo;
    @OneToMany
    private List<Vaga> vagas = new LinkedList<>();
    private boolean classificado;

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public boolean isClassificado() {
        return classificado;
    }

    public void setClassificado(boolean classificado) {
        this.classificado = classificado;
    }

    public String getCurriculo() {
        return Curriculo;
    }

    public void setCurriculo(String Curriculo) {
        this.Curriculo = Curriculo;
    }
    
    public void addVaga(Vaga vaga){
        vagas.add(vaga);
    }
    
    public void remVaga(Vaga vaga){
        vagas.remove(vaga);
    }
    
    
}
