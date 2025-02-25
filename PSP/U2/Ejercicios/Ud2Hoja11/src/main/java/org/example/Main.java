package org.example;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Fiesta f = new Fiesta();

        f.start();

        try {
            sleep(10);
            for(int i=1; i<=10; i++){
                new Cliente(f, i).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}