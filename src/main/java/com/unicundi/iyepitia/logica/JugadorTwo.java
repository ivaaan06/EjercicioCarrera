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
public class JugadorTwo extends Thread implements IEquipo{
    /**
     * indica el nombre del jugador 2
     */
    private String equipo;
    /**
     * indica el nombre del equipo
     */
    private String nombre;
    /**
     * indica las posiciones que toma el jugador 2
     */
    private ArrayList lista = new ArrayList();
  /**
 * Constructor 
 * @param nombre
 * @param lista
 * @param equipo 
 */ 
    public JugadorTwo(String nombre,ArrayList lista,String equipo) {
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
     // Finaliza Run 
    /**
     * Metodo en el cual se envian las posiciones para
     * mostrar el prograso del hilo, y dentro de este 
     * se hace una impresion para evidenciar como aumenta la posición
     */
    public void avanzar(){
         int posicion=0;
         int j=0;
         lista.clear();
          Collections.sort(lista);
        while(posicion != 20){
            try{
                
                Thread.sleep(1000);
                posicion = (int) Math.floor(Math.random()*(20-11+1)+11);
                lista.add(posicion);
                System.out.println(""+equipo);
                System.out.println("Corredor 2 "+nombre+" Progreso ");
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
         //System.out.println(lista.get(j));
         // se aumenta el contador j
            
            j++;
            
        }
        /**
         * se notifica el Hilo para despertarlo 
         */
        //volver a revisar la condicion
        lista.notifyAll();
      
    }
     // Cierre metodo Avanzar 
      /**
     * Get de Lista
     * @return 
     */

    public ArrayList getLista() {
        return lista;
    }
    
    
}
