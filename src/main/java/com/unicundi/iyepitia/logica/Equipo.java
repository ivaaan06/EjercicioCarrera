/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.logica;

import java.util.ArrayList;

/**
 *
 * @author Ivan Espitia
 * @Caren Rodriguez
 * 
 */
/**
 * 
 * Clase Equipo se crea la variable privada posicion 
 * 
 */
public class Equipo {
    private int posicion;
/**
 * Get Lista 
 * @return 
 */
    public ArrayList getLista() {
        return lista;
    }
/**
 * Set Lista 
 * @param lista 
 */
    public void setLista(ArrayList lista) {
        this.lista = lista;
    }
  /**
   * Instancia de ArrayList 
   */  
    private ArrayList lista = new ArrayList();
}
