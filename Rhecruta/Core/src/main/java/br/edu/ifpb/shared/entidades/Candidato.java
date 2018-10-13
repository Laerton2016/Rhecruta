/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.entidades;

import java.io.File;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author laerton
 */
@Entity
public class Candidato extends Pessoa{
    private File Curriculo;
    @OneToMany
    private List<Vaga> vagas;
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

    public File getCurriculo() {
        return Curriculo;
    }

    public void setCurriculo(File Curriculo) {
        this.Curriculo = Curriculo;
    }
    
    
    
}
