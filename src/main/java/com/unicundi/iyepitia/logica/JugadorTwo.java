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

/**
 *
 * @author Ivan Espitia
 */
public class JugadorTwo extends Thread{
    private String equipo;
    private String nombre;
    private ArrayList lista = new ArrayList();
   
    public JugadorTwo(String nombre,ArrayList lista,String equipo) {
        this.nombre = nombre;
        this.lista = lista;
        this.equipo = equipo;
    }
    
    
    
    
    @Override
    public void run(){
        
           synchronized(lista){
            int aux = (int) lista.get(lista.size()-1);
            //si el valor final de la cola es diferente de 10 dormir hilo
            if(aux!=10){
             try {
                    lista.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(JugadorTwo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
               
            //System.out.println("Comienza a correr " +nombre);
            avanzar();
         
        
         }
        
    }
    public void avanzar(){
         int posicion=0;
         int j=0;
         //lista.clear();
          Collections.sort(lista);
        while(posicion != 20){
            try{
                
                Thread.sleep(1000);
                posicion = (int) Math.floor(Math.random()*(20-11+1)+11);
                lista.add(posicion);
                  System.out.println(""+equipo);
                System.out.println("Corredor 2 Progreso "+nombre);
                for (int i=0;i<(int)lista.get(j);i++) {
               
                System.out.print("*");
                }
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
            }catch(InterruptedException e){
                
            }
           Collections.sort(lista);
            //System.out.println(lista.get(j));
        
            
            j++;
            
        }
        //volver a revisar la condicion
        lista.notifyAll();
      
    }

    public ArrayList getLista() {
        return lista;
    }
    
    
}
