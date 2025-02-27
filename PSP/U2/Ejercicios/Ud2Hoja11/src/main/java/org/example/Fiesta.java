package org.example;

public class Fiesta extends Thread{
    private int racionesTotales;
    private int racionPaella;

    public Fiesta(){
        this.racionesTotales = 120;
        this.racionPaella = 40;
    }

    public synchronized void run(){
        try{
            System.out.println("La fiesta ha comenzado hay "+racionesTotales+" raciones");
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private synchronized void recargaPaella(){
        try{
            if(racionesTotales>0){
                System.out.println("Llenando la paellera hay "+racionesTotales+" raciones");
                sleep(25);
                racionPaella = 40;
            }else{
                System.out.println("No hay suficientes raciones para cambiar la paellera");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }


    public synchronized void sirveRacion(int id){
        try{
            if(racionPaella>1 && racionesTotales>0){
                racionPaella--;
                racionesTotales--;
                System.out.println("Cliente "+id+" se sirve una racion - "+racionPaella+"/"+racionesTotales);

            }else if(racionPaella>0 && racionesTotales>0) {
                racionPaella--;
                racionesTotales--;
                System.out.println("Cliente "+id+" se sirve una racion - "+racionPaella+"/"+racionesTotales);
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

    public int getRacionPaella() {
        return racionPaella;
    }

}
