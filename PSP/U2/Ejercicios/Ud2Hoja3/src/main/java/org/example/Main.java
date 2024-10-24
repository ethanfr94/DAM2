package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Cola cola = new Cola();
        Prod p = new Prod(cola, 1);
        Cons c = new Cons(cola, 1);
        p.start();
        c.start();

    }
}