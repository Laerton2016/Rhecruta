package br.edu.ifpb.shared.interfaces;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laerton
 */

public interface IDAO <T> {
    void save(T obj);
    void update (T obj);
    T findById (long id);
    List<T> findAll ();
    void remove (long id);
   
}
