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
 * @author Caren Rodriguez
 */
/**
 * 
 * Clase publica de los jugadores no 1 de cada equipo, 
 * con una extensión a la clase Thread, la cual inicializa
 * valiables privadas y un ArrayList
 */
public class JugadorOne extends Thread {
    private String nombre;
    private String equipo;
    private ArrayList lista = new ArrayList();
   
    /**
     * 
     * @param nombre
     * @param lista
     * @param equipo 
     * Constructor de la clase 
     */

     public JugadorOne(String nombre,ArrayList lista,String equipo) {
        this.nombre = nombre;
        this.lista = lista;
        this.equipo = equipo;
    }
    
    
    /**
     * Metodo de la interfaz Runnable, empiezan a correr 
     * los jugadores, y llama al metodo avanzar.
     */
    @Override
    public void run(){
       
         synchronized(lista){
             System.out.println("Comienza a correr "+nombre);
            avanzar();
            
            
        }
         
    }// Finaliza Run 
    /**
     * Metodo en el cual se envian las posiciones para
     * mostrar el prograso del hilo, y dentro de este 
     * se hace una impresion para evidenciar como aumenta la posición
     */
    public void avanzar(){
        
        int posicion=0;
        int j=0;
        while(posicion != 10){
            
            try{
                
                Thread.sleep(1000);
                posicion = (int) Math.floor(Math.random()*(10-1+1)+1);
                lista.add(posicion);
                System.out.println(""+equipo);
                System.out.println("Corredor 1 Progreso "+nombre);
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
            // se aumenta el contador j
            j++;
            }
        /**
         * se notifica el Hilo para despertarlo 
         */
        lista.notifyAll();
        
    }// Cierre metodo Avanzar 
      /**
     * Get de lista 
     * @return 
     */
    public ArrayList getLista() {
        return lista;
    }
    /**
     * Get de Nombre 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Get de Equipo 
     * @return 
     */
    public String getEquipo() {
        return equipo;
    }

    
    
    
    
    
    
}
