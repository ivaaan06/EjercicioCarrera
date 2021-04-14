/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.iyespitia.principal;

import com.unicundi.iyepitia.logica.JugadorOne;
import com.unicundi.iyepitia.logica.JugadorThree;
import com.unicundi.iyepitia.logica.JugadorTwo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;

/**
 *
 * @author Ivan Espitia
 */
public class principal {
    public static void main(String[] args) {
      ArrayList posicionesEquipo1 = new ArrayList();
      JugadorOne jug1Equipo1 = new JugadorOne("Ivan",posicionesEquipo1,"Equipo1");
      JugadorTwo jug2Equipo1 = new JugadorTwo("Maria",posicionesEquipo1,"Equipo1");
      JugadorThree jug3Equipo1= new JugadorThree("Angel", posicionesEquipo1, "Equipo1");
      
      ArrayList posicionesEquipo2 = new ArrayList();
      JugadorOne jug1Equipo2 = new JugadorOne("Ivan2",posicionesEquipo2,"Equipo2");
      JugadorTwo jug2Equipo2 = new JugadorTwo("Maria2",posicionesEquipo2 ,"Equipo2");
      JugadorThree jug3Equipo2= new JugadorThree("Angela2", posicionesEquipo2,"Equipo2");
      
      ArrayList posicionesEquipo3 = new ArrayList();
      JugadorOne jug1Equipo3 = new JugadorOne("Ivan3",posicionesEquipo3,"Equipo3");
      JugadorTwo jug2Equipo3 = new JugadorTwo("Maria3",posicionesEquipo3,"Equipo3");
      JugadorThree jug3Equipo3= new JugadorThree("Angela3", posicionesEquipo3,"Equipo3");
      
     
      
      
     
         
     
        jug1Equipo1.start();
        jug1Equipo2.start();
        jug1Equipo3.start();
     
      
        jug2Equipo1.start();
        jug2Equipo2.start();
        jug2Equipo3.start();
      
        jug3Equipo1.start();
        jug3Equipo2.start();
        jug3Equipo3.start();
        
        //suspdender el hilo principal hasta que haya un ganador
        while(jug3Equipo1.getEstado() != "Ganador" || jug3Equipo2.getEstado() != "Ganador"  || jug3Equipo3.getEstado() != "Ganador" ){
          try {
              Thread.sleep(1);
              //System.out.println("hola perra");
          } catch (InterruptedException ex) {
              Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
          if (jug3Equipo1.getEstado().equals("Ganador")){
              jug2Equipo2.currentThread().interrupt();
              jug3Equipo2.currentThread().interrupt();
              jug2Equipo3.currentThread().interrupt();
              jug3Equipo3.currentThread().interrupt();
              
          }
          if(jug3Equipo2.getEstado().equals("Ganador")){
              jug2Equipo1.currentThread().interrupt();
              jug3Equipo1.currentThread().interrupt();
              jug2Equipo3.currentThread().interrupt();
              jug3Equipo3.currentThread().interrupt();
          }
          if(jug3Equipo3.getEstado().equals("Ganador")){
              jug2Equipo2.currentThread().interrupt();
              jug3Equipo2.currentThread().interrupt();
              jug2Equipo1.currentThread().interrupt();
              jug3Equipo1.currentThread().interrupt();
          }       
        //jug1Equipo3.interrupt();
        //jug2Equipo3.interrupt();
        //jug3Equipo3.interrupt();
        
        
            
          

        
        
    }    


}

