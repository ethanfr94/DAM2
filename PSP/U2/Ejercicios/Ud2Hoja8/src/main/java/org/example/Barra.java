package org.example;

import java.util.ArrayList;
import java.util.List;

public class Barra extends Thread{

   private int id = 0;
   private int turno;
   private Fiesta fiesta;
   private int cola;

    public Barra(Fiesta fiesta, int id){
         this.id = id;
         this.fiesta = fiesta;
         this.turno = 0;
    }

    public void run() {

        try {
            while (true) {
                wait();
                fiesta.servir(id);
                turno++;
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getCola(){
        if(id == 1){
            cola = fiesta.getColaDcha();
        }else{
            cola = fiesta.getColaIzq();
        }
    }



    @Override
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fiesta getFiesta() {
        return fiesta;
    }

    public void setFiesta(Fiesta fiesta) {
        this.fiesta = fiesta;
    }


}
