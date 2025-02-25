package org.example;

public class Cliente extends Thread{
    private int id;
    private Fiesta f;

    public Cliente(Fiesta fiesta, int id){
        this.id = id;
        this.f = fiesta;
    }

    public synchronized void run(){
        try{
            do{
                System.out.println("Cliente "+id+" esperando a que se sirva la paella");

                f.sirveRacion();
                System.out.println("Cliente "+id+" se ha servido una racion quedan "+f.getRacionesTotales()+" raciones");
                sleep(40);
                System.out.println("Cliente "+id+" ha terminado de comer");
            }while(f.getRacionesTotales()>0);

        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }

}
