public class Granjero extends Thread {
    private Gallinero gallinero;
    private int huevos;
    public int rotos;


    public Granjero(Gallinero gallinero) {
        this.gallinero = gallinero;
        huevos = 0;
    }

    public synchronized void recogerHuevos(){
        for (int i = 0; i < gallinero.ponedero.length; i++) {
            if(gallinero.ponedero[i] == 1){
                huevos++;
                System.out.println("El granjero ha recogido un huevo");
                gallinero.ponedero[i] = 0;
            }
        }
    }

    public void run() {
        for (int i = 0; i < 365; i++) {
            try {
                sleep(12);
                recogerHuevos();
                sleep(12);

            } catch (InterruptedException ex) {
                System.out.println("Error en el granjero");
            }
        }
        rotos = gallinero.getRotos();
        System.out.println("El granjero ha recogido " + huevos + " huevos");
        System.out.println("El granjero ha perdido " + rotos + " huevos");
    }

}
