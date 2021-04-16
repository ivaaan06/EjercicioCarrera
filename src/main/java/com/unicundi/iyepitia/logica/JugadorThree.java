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
 * @autor Caren Rodriguez
 */
/**
 * Clase JugadorThree extension de Thread, 
 * en la cual se inicializan variables de tipo privado 
 * y se realiza una instancia de ArrayList
 * 
 */
public class JugadorThree extends Thread {
    private String estado;
    private String equipo;
    private String nombre;
    private ArrayList lista = new ArrayList();
    private int estado2=1;
/**
 * Constructor 
 * @param nombre
 * @param lista
 * @param equipo 
 */
    public JugadorThree(String nombre,ArrayList lista,String equipo) {
        this.nombre = nombre;
        this.lista = lista;
        this.equipo = equipo;
    }
    /**
     * Metodo de la interfaz Runnable, empiezan a correr 
     * los jugadores, según la condición, se entrara al if 
     * en el cual se encuentra el wait, para dormir el hilo 
     * según sea necesario, de lo contrario se llama el metodo avanzar.
     */
   
    @Override
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
                //System.out.println("Comienza a correr "+nombre);
            
                avanzar();
         
        }
         
        // Finaliza Run 
    /**
     * Metodo en el cual se envian las posiciones para
     * mostrar el prograso del hilo, y dentro de este 
     * se hace una impresion para evidenciar como aumenta la posición
     */
    }
    public void avanzar(){
         int posicion=0;
         int j=0;
          Collections.sort(lista);
         //lista.clear();
        while(posicion != 30){
            try{
                
                Thread.sleep(1000);
                posicion = (int) Math.floor(Math.random()*(30-21+1)+21);
                lista.add(posicion);
                  System.out.println(""+equipo);
                System.out.println("Corredor 3 Progreso "+nombre);
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
        if (lista.get(lista.size()-1).equals(30)){
            //exit();
            estado="Ganador";
            System.out.println("Ganadores :"+equipo);
            System.exit(0);
           
        }
        
        
        
      
    }
    // Cierre metodo Avanzar 
      /**
     * Get de Estado 
     * @return 
     */

    public String getEstado() {
        return estado;
    }

        /**
     * Get de Lista
     * @return 
     */
    
    public ArrayList getLista() {
        return lista;
    }
    
    
}
