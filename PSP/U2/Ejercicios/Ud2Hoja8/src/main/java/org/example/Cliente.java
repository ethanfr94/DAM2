package org.example;

public class Cliente extends Thread{

    public int copa;
    private Barra barra;

    public Cliente() {
        this.copa = 0;
    }

    public synchronized void entrar(Fiesta fiesta, Barra bar) {
        try {
            sleep(75);
            if (fiesta.cola1 > fiesta.cola2) {
                fiesta.cola2++;
                barra = bar;
            } else if (fiesta.cola2 < fiesta.cola1) {
                fiesta.cola1++;
            } else {
                fiesta.cola1++;
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void beber(){
        try {
            int n = (int) (Math.random() * 601);
            sleep(n);
            this.copa++;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void dejarCola(Fiesta fiesta) {
        try {
            sleep(5);
            if (fiesta.cola1 > fiesta.cola2) {
                fiesta.cola1--;
            } else if (fiesta.cola2 < fiesta.cola1) {
                fiesta.cola2--;
            } else {
                fiesta.cola1--;
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
