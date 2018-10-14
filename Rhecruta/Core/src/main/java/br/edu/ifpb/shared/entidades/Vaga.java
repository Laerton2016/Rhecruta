/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author laerton
 */
@Entity
public class Vaga {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String cidade;
    private String empresa;
    private String UF;
    public Vaga() {
    }

    
    /***
     * Cria uma vaga pelos paramentros repassados
     * @param descricao - Descrição da vaga 
     * @param cidade - Nome da cidade 
     * @param empresa - Dados da empresa
     */
    
    public Vaga( String cidade,  String empresa, int id) {
        
        this.cidade = cidade;
        this.empresa = empresa;
        this.id = id;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    
    
    
}
