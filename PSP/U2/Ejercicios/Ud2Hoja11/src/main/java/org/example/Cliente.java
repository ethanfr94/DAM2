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
                while(f.getRacionPaella()==0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                f.sirveRacion(id);
                sleep(40);
                System.out.println("Cliente "+id+" ha terminado de comer");
            }while(f.getRacionesTotales()>0);
        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }

}
