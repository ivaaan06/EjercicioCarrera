/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyespitia.principal;


import com.unicundi.iyepitia.logica.Index;
import com.unicundi.iyepitia.logica.JugadorOne;
import com.unicundi.iyepitia.logica.JugadorThree;
import com.unicundi.iyepitia.logica.JugadorTwo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ivan Espitia
 * @author caren
 * version 1.0.0
 * 
 */

/**
 * Clase Principal, envia los nombres y los respectivos equipos 
 * 
 */
public class principal {
    /**
     * Main, instancias, inicio de los Hilos a traves del metodo start  
     * @param args 
     */
    public static void main(String[] args) {
        Index index = new Index();
        index.inicio();
        
    }    


}

