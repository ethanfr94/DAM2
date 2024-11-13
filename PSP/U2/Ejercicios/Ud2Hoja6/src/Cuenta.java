public class Cuenta {
    private int saldo;
    private int maximo;

    public Cuenta(int saldo, int maximo) {
        this.saldo = saldo;
        this.maximo = maximo;
    }

    public int getSaldo() {
        return saldo;
    }


    public synchronized void ingreso(int cantidad, String n) {
        System.out.println("\n"+n+"--intento de ingrerso de " + cantidad + "€");
        if (saldo + cantidad < maximo) {
            saldo += cantidad;
            System.out.println( "Ingreso de " + cantidad + "€. Saldo actual: " + saldo + "€");
        }else{
            System.out.println("Ingreso máximo superado");
            System.exit(1);
        }

    }

    public synchronized void reintegro(int cantidad, String n) {
        System.out.println("\n"+n+"--intento de retirada de " + cantidad + "€");
        if(cantidad < saldo) {
            saldo -= cantidad;
            System.out.println( "Retirada de " + cantidad + "€. Saldo actual: " + saldo + "€");
        }else{
            System.out.println("Saldo insuficiente");
            System.exit(1);
        }

    }
}

