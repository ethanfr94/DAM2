public class Gallina extends Thread{
    private int id = 0;
    private Gallinero gallinero;



    public Gallina(int id, Gallinero gallinero) {
        this.id = id;
        this.gallinero = gallinero;
    }

    public synchronized void ponerHuevo(){
            if(gallinero.ponedero[id] == 1){
                gallinero.rompeHuevo(id);
                System.out.println("La gallina "+id+" ha roto un huevo");
            }
            gallinero.addhuevo(id);
        System.out.println("La gallina "+id+" ha puesto un huevo");
    }

    public void run(){
        for(int i = 0; i < 365; i++){
            int random = (int) (Math.random() * 24)+1;
            try {
                sleep(random);
                ponerHuevo();
                sleep(24 - random);
                System.out.println("----------------------------------------");
            } catch (InterruptedException ex) {
                System.out.println("Error en la gallina");
            }
        }
    }

}
