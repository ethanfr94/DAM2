package org.example;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Fiesta {

    private int colaIzq;
    private int colaDcha;
    private int bebidas;

    public Fiesta(){
        colaIzq = 0;
        colaDcha = 0;
        bebidas = 0;
    }

   public synchronized void servir(int id){
       try {
           wait();
           sleep(100);
           bebidas++;
           notify();

       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

   public synchronized void recoger(int id) {
       try{
              wait();

              notify();
       } catch (InterruptedException e) {
              e.printStackTrace();
       }
   }

    public int getColaIzq() {
        return colaIzq;
    }


    public int getColaDcha() {
        return colaDcha;
    }

    public void setColaIzq() {
        this.colaIzq++;
    }

    public void setColaDcha() {
        this.colaDcha++;
    }
}