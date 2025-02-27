package org.example;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Fiesta f = new Fiesta();

        try {
            for(int i=1; i<=10; i++){
                sleep(10);
                new Cliente(f, i).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}