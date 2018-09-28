/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.services;

import br.edu.ifpb.shared.entidades.Vaga;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author laerton
 */
public class main {
    public static void main(String[] args) {
        VagaService vs = new VagaService();
        List<Vaga> vagasWeb = vs.findByDescricao("NYC-based");
        for (Vaga object : vagasWeb) {
            System.out.println(object.getDescricao()+ " - " + object.getCidade());
        }
        
               
        
    }
}
