public class Gallinero {
    public int[] ponedero = new int[5];
    private int rotos = 0;

    public void addhuevo(int n) {
        ponedero[n] = 1;
    }

    public int getRotos() {
        return rotos;
    }

    public void rompeHuevo(int n) {
        ponedero[n] = 0;
        rotos++;
    }



}
