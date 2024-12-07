package org.example;

public class Cola {
    private String msg;
    private boolean hay = false;

    public synchronized String get() {
        while(!hay){
            try{
                wait();
            }catch (Exception e){}
        }
        hay = false;
        notify();
        return msg;
    }

    public synchronized void put (String valor) {
        while(hay){
            try{
                wait();
            }catch (Exception e){}
        }
        msg = valor;
        hay = true;
        notify();
    }

    // asi seria con semaforos
    /*
    public String get() {
        return msg;
    }

    public void put (String valor) {
        msg = valor;
    }
    */


}
