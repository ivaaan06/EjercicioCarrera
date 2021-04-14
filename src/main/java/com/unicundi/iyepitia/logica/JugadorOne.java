/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Ivan Espitia
 */
public class JugadorOne extends Thread {
    private String nombre;
    private ArrayList lista = new ArrayList();
    

     public JugadorOne(String nombre,ArrayList lista) {
        this.nombre = nombre;
        this.lista = lista;
    }
    
    
    
    
    public void run(){
         synchronized(lista){
             System.out.println("Comienza a correr "+nombre);
            avanzar();
            
        }
         
    }
    public void avanzar(){
       
        int posicion=0;
        int j=0;
        while(posicion != 10){
            try{
                
                Thread.sleep(500);
                posicion = (int) Math.floor(Math.random()*(10-1+1)+1);
                lista.add(posicion);
                
            }catch(InterruptedException e){
                
            }
           Collections.sort(lista);
            System.out.println(lista.get(j));
          
            j++;
        }
        lista.notifyAll();
       
    }

    public ArrayList getLista() {
        return lista;
    }

    public void setLista(ArrayList lista) {
        this.lista = lista;
    }
    
    
    
}
