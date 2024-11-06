package org.example;

import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Semaphore prod = new Semaphore(1);
        Semaphore cons = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);

        Cola cola = new Cola();
        Prod p = new Prod(cola, 1, prod, cons, mutex);
        Cons c = new Cons(cola, 1, prod, cons, mutex);
        p.start();
        c.start();
    }
}