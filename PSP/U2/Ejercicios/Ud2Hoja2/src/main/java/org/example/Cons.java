package org.example;

public class Cons extends Thread {
    private Cola cola;  private int n;
    public Cons (Cola c, int n){ cola = c; this.n =n;
    }
    public void run() {
        int valor = 0;
        for (int i = 0; i>=0; i++) {
            try {
                sleep(100);
                valor = cola.get(); //recoge el numero
                System.out.println(i+"=>Consumidor : " + n + ", consume: " + valor+"---------------");
                sleep(100);
            } catch (InterruptedException e) { throw new RuntimeException(e); }
        }
    }
}

