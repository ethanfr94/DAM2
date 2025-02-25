package org.example;

public class Fiesta extends Thread{
    private int racionesTotales;
    private int racionPaella;

    public Fiesta(){
        this.racionesTotales = 40;
        this.racionPaella = 10;
    }

    public synchronized void run(){
        try{
            System.out.println("La fiesta ha comenzado hay "+racionesTotales+" raciones");
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void recargaPaella(){
        try{
            if(racionesTotales>0){
                System.out.println("Llenando la paellera hay "+racionesTotales+" raciones");
                sleep(25);
                racionPaella = 10;
            }else{
                System.out.println("No hay suficientes raciones para cambiar la paellera");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }


    public synchronized void sirveRacion(){
        try{
            //wait();
            if(racionPaella>0 && racionesTotales>0){
                racionPaella--;
                racionesTotales--;
            }else{
                System.out.println("la paellera esta vacia llamando al cocinero para cambiuarla");
                recargaPaella();
            }
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public int getRacionesTotales() {
        return racionesTotales;
    }
}
