/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.services;




import br.edu.ifpb.shared.entidades.Vaga;
import br.edu.ifpb.shared.persistencia.DAOVaga;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author laerton
 */
@Stateless
public class VagaService {
 
    private final String endereco = "http://www.pyjobs.com.br/api/jobs/";
    private static int HTTP_COD_SUCESSO = 200;
    private List<Vaga> vagasWeb = new LinkedList<Vaga>();
    
    @Inject
    private DAOVaga daoVaga;
    
    public VagaService() 
    {
        try {
            montaLista(ler());
        } catch (IOException ex) {
            Logger.getLogger(VagaService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(VagaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    private JSONArray ler () throws MalformedURLException, IOException, JAXBException {
            
            StringBuilder sb = new StringBuilder();
        try{
            HttpURLConnection httpcon = (HttpURLConnection) ((new URL(endereco).openConnection()));
            httpcon.connect();            
            BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream(),Charset.forName("UTF-8")));
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
                sb.append(inputLine);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject(sb.toString()).getJSONArray("objects") ;
    }
    private void montaLista(JSONArray dados){
        
        for (int i = 0; i < dados.length(); i++) {
            JSONObject job = dados.getJSONObject(i);
            String cidade = job.getString("workplace");
            String descricao = job.getString("description");
            String companhia = job.getString("company_name");
            int id = job.getInt("id");
            vagasWeb.add(new Vaga(descricao, cidade, companhia, id));
        }
    }

    public List<Vaga> getVagasWeb() {
        return vagasWeb;
    }
    
    public List<Vaga> findByCidade(String cidade){
        List<Vaga> retorno = new LinkedList<Vaga>();
        for (Vaga vaga : this.vagasWeb) {
            if (vaga.getCidade().toUpperCase().contains(cidade.toUpperCase())){
                retorno.add(vaga);
            }
        }
        return retorno;
    }
    
    public List<Vaga> findByEmpresa(String empresa){
        List<Vaga> retorno = new LinkedList<Vaga>();
        for (Vaga vaga : this.vagasWeb) {
            if (vaga.getEmpresa().toUpperCase().contains(empresa.toUpperCase())){
                retorno.add(vaga);
            }
        }
        return retorno;
    }
    
    public List<Vaga> findByDescricao(String descricao){
        List<Vaga> retorno = new LinkedList<Vaga>();
        for (Vaga vaga : this.vagasWeb) {
            if (vaga.getDescricao().toUpperCase().contains(descricao.toUpperCase())){
                retorno.add(vaga);
            }
        }
        return retorno;
    }
    
    /***
     * Lista todas as vagas no banco
     * @return - Lista de vagas no banco
     */
    public List<Vaga> findAllVagasBanco(){
        return daoVaga.findAll();
    }
    /***
     * Busca por uma Vaga pelo ID repassado
     * @param idVaga = Id da vaga 
     * @return  Vaga localizada ou Null
     */
    public Vaga findVagaBancoById(int idVaga){
        return daoVaga.findById(idVaga);
    }
    /***
     * Salva os dados de uma vaga no banco.
     * @param vaga - Vaga cujos dados serão salvos
     */
    public void saveVagaBanco(Vaga vaga){
        if (vaga.getId() == 0){
            daoVaga.save(vaga);
        }else{
            daoVaga.update(vaga);
        }
    }
    /***
     * Remove uma vaga do banco pelo ID repassado
     * @param idVaga = Id da vaga.
     */
    public void removeVagaDoBanco(int idVaga){
        daoVaga.remove(idVaga);
    }
    
    /***
     * Lista vagas de uma determinada cidade
     * @param ciadde - Cidade a ser filtrada
     * @return - Lista de vagas de uma determinada cidade
     */
    public List<Vaga> findVagaBancoByCidade(String ciadde){
        return daoVaga.findByCidade(ciadde);
    }
    
    /***
     * Lista de vagas de uma determinada empresa
     * @param empresa - Empresa a ser filtrada
     * @return - Lista de vagas filtradas
     */
    public List<Vaga> findVagasBancoByEmpresa(String empresa){
        return daoVaga.findByEmpresa(empresa);
    }
    
    /***
     * Lista de vagas baseado em um termo repassado como referencia de descrição 
     * @param termo - Termo a ser refereciado
     * @return - Lista de vagas
     */
    public List<Vaga> findVagaBancoByReferencia(String termo){
        return daoVaga.findByReferencia(termo);
    }
    
    
    
    
    
 }
