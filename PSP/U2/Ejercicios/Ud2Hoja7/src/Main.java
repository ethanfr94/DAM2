public class Main {
    public static void main(String[] args) {
        Gallinero gallinero = new Gallinero();
        Granjero granjero = new Granjero(gallinero);
        for (int i = 0; i < 5; i++) {
            Gallina gallina = new Gallina((i+1), gallinero);
            gallina.start();
        }
        granjero.start();
    }
}