/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyepitia.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;

/**
 *
 * @author Ivan Espitia
 */
public class JugadorThree extends Thread {
    private String estado;
    private String equipo;
    private String nombre;
    private ArrayList lista = new ArrayList();

    public JugadorThree(String nombre,ArrayList lista,String equipo) {
        this.nombre = nombre;
        this.lista = lista;
        this.equipo = equipo;
    }
    
   
    
    public void run(){
        
        synchronized(lista){
            int aux = (int) lista.get(lista.size()-1);
            //si el valor final de la cola es diferente de 20 dormir hilo
            
            if(aux!=20){
             try {
                    lista.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(JugadorTwo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                System.out.println("Comienza a correr "+nombre);
            
                avanzar();
         
        }
         
        
    }
    public void avanzar(){
         int posicion=0;
         int j=0;
         lista.clear();
        while(posicion != 30){
            try{
                
                Thread.sleep(500);
                posicion = (int) Math.floor(Math.random()*(30-21+1)+21);
                lista.add(posicion);
                
            }catch(InterruptedException e){
                
            }
           Collections.sort(lista);
            System.out.println(lista.get(j));
           
            j++;
            
        }
        if (lista.get(lista.size()-1).equals(30)){
            estado="Ganador";
            System.out.println("Ganadores :"+equipo);
            System.exit(0);
           
        }
        
        
        
      
    }

    public String getEstado() {
        return estado;
    }
}
