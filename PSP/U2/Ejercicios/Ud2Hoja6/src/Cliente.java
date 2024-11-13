import static java.lang.Math.random;

public class Cliente extends Thread{

    private String nombre;
    private Cuenta cuenta;
    private int cantidad;

    public Cliente(String nombre, Cuenta cuenta){
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public int aleatorio(){
        cantidad = (int) (random()*500+1);
        return cantidad;
    }

    public void run(){
            try {
                for (int i = 0; i < 4; i++) {

                    if (i % 2 == 0) {
                        cuenta.ingreso(aleatorio(), nombre);
                        sleep(500);
                    }else{
                        cuenta.reintegro(aleatorio(), nombre);
                        sleep(500);
                    }
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
    }

}
