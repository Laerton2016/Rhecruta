/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.core.services;

import br.edu.ifpb.shared.entidades.Avaliacao;
import br.edu.ifpb.shared.persistencia.DAOAvaliacao;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *
 * @author laerton
 */
@Stateless
public class AvaliacaoService {
    
    @Inject
    private DAOAvaliacao daoAvaliacao;
    /***
     * Salva os dados de uma valiação
     * @param avaliacao 
     */
    public void save(Avaliacao avaliacao){
        if (avaliacao.getId()== 0){
            daoAvaliacao.save(avaliacao);
        }else {
            daoAvaliacao.update(avaliacao);
        }
        
    }
    /***
     * Remove os dados de uma avaliação pelo id repassado
     * @param id - id da avaliação a ser removido
     */
    public void remove(int id){
        daoAvaliacao.remove(id);
    }
    /***
     * Lista todas as avalaições cadastradas.
     * @return 
     */
    public List<Avaliacao> findAll(){
        return daoAvaliacao.findAll();
        
    }
    /***
     * Lista todas as avaliação de um candidato
     * @param idCandidato - ID do candidato 
     * @return 
     */
    public List<Avaliacao> findByIdCanidato(int idCandidato){
        return daoAvaliacao.findAvaliacaoByCandidato(idCandidato);
    }
    /***
     * Lista todas as avaliações de uma avaliador
     * @param idAvaliador - ID do avalaidor
     * @return 
     */
    public List<Avaliacao> findByIdAvaliador(int idAvaliador){
        return daoAvaliacao.findAvaliacaoByAvaliador(idAvaliador);
    }
    /***
     * Lista de avaliações de uma avaliador filtrado pelo candidato
     * @param idAvaliador - ID Avaliador 
     * @param idCandidato - ID candidato
     * @return 
     */
    public List<Avaliacao> findByAvaliadorAndCandidato(int idAvaliador, int idCandidato){
        List<Avaliacao> lista = findByIdAvaliador(idAvaliador);
        List<Avaliacao> ret = new LinkedList<>();
        for (Avaliacao avaliacao : lista) {
            if (avaliacao.getCandidato().getId() == idCandidato){
                ret.add(avaliacao);
            }
        }
        return ret;
    }
    /***
     * Lista todas as avalaiações de um avaliador filrada por uma determinada vaga
     * @param idAvaliador - ID Avalaiador
     * @param idVaga - ID Vaga
     * @return 
     */
    public List<Avaliacao> findByAvaliadorAndVaga(int idAvaliador, int idVaga){
        List<Avaliacao> lista = findByIdAvaliador(idAvaliador);
        List<Avaliacao> ret = new LinkedList<>();
        for (Avaliacao avaliacao : lista) {
            if (avaliacao.getVaga().getId() == idVaga){
                ret.add(avaliacao);
            }
        }
        return ret;
    }
    /***
     * Busca uma avaliação pelo id 
     * @param id - ID da avaliação
     * @return 
     */
    public Avaliacao findById (int id){
        return daoAvaliacao.findById(id);
    }
    
    /***
     * Agenda a data e hora de uma avalaição
     * @param idAvaliacao - Id da avaliação
     * @param data - Data
     * @param hora - Hora
     */
    public void AgaendarAvacao(int idAvaliacao, LocalDate data, LocalDate hora){
        Avaliacao a = daoAvaliacao.findById(idAvaliacao);
        if (a.isCancelado() == true){
            a.setCancelado(false);
        }
        a.setData(data);
        a.setHora(hora);
        this.save(a);
        
    }
    /***
     * Cancela uma avaliação
     * @param avaliacao 
     */
    public void cancelarAvaliacao (Avaliacao avaliacao){
        avaliacao.setCancelado(true);
        save(avaliacao);
    }
    
    
    
}
