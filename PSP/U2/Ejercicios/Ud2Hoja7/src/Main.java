public class Main {
    public static void main(String[] args) {
        Gallinero gallinero = new Gallinero();
        Granjero granjero = new Granjero(gallinero);
        Gallina gallina1 = new Gallina(0, gallinero);
        Gallina gallina2 = new Gallina(1, gallinero);
        Gallina gallina3 = new Gallina(2, gallinero);
        Gallina gallina4 = new Gallina(3, gallinero);
        Gallina gallina5 = new Gallina(4, gallinero);
        gallina1.start();
        gallina2.start();
        gallina3.start();
        gallina4.start();
        gallina5.start();
        granjero.start();
    }
}