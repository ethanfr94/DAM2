package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //extiende Thread
       /* Hilo1 hilo1 = new Hilo1();
        Hilo2 hilo2 = new Hilo2();
        hilo1.start();
        hilo2.start(); */

        //implementa Runnable
        Tic tic = new Tic();
        Tac tac = new Tac();
        Thread t1 = new Thread(tic);
        Thread t2 = new Thread(tac);
        t1.start();
        t2.start();
    }
}