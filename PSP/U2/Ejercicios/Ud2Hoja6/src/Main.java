public class Main {
    public static void main(String[] args) {

        Cuenta cuenta = new Cuenta(0, 1000);
        Cliente pepe = new Cliente("Pepe", cuenta);
        Cliente juan = new Cliente("Juan", cuenta);
        Cliente maria = new Cliente("Maria", cuenta);
        Cliente ana = new Cliente("Ana", cuenta);


        pepe.start();
        juan.start();
        maria.start();
        ana.start();



    }
}