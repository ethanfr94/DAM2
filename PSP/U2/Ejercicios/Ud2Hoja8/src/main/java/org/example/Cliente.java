package org.example;

public class Cliente extends Thread{

    private int id;
    private Fiesta fiesta;
    private int turno;

    public Cliente(Fiesta fiesta){
        this.fiesta = fiesta;
    }

    public void run(){
        try{
            while(true){
                elige();
                switch (id){
                    case 1->{
                        if(turno > fiesta.getColaIzq()){
                            wait();
                        }
                        fiesta.recoger(id);
                    }
                    case 2->{
                        if(turno > fiesta.getColaDcha()){
                            wait();
                        }
                        fiesta.recoger(id);
                    }
                }
                notify();
                bebe();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void elige(){
        if(fiesta.getColaIzq() < fiesta.getColaDcha()){

            this.id = 1;
            fiesta.setColaIzq();
            turno = fiesta.getColaIzq();

        }else if(fiesta.getColaIzq() > fiesta.getColaDcha()){

            this.id = 2;
            fiesta.setColaDcha();
            turno = fiesta.getColaDcha();

        }else{

            this.id = (int) (Math.random() * 2) + 1;

            if (id == 1){
                fiesta.setColaIzq();
                turno = fiesta.getColaIzq();
            }
            else{
                fiesta.setColaDcha();
                turno = fiesta.getColaDcha();

            }
        }
    }

    public void bebe(){
        try {

            int n = (int) (Math.random() * 600) + 1;
            sleep(n);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fiesta getFiesta() {
        return fiesta;
    }

    public void setFiesta(Fiesta fiesta) {
        this.fiesta = fiesta;
    }
}
