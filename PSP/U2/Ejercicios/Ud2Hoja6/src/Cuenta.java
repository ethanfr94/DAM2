public class Cuenta {
    private int saldo;
    private int maximo;
    private boolean fin = false;

    public Cuenta(int saldo, int maximo) {
        this.saldo = saldo;
        this.maximo = maximo;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getMaximo() {
        return maximo;
    }

    public boolean getFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public synchronized void ingreso(int cantidad, String n) {
        System.out.println("\n"+n+"--intento de ingrerso de " + cantidad + "€");
        if (saldo + cantidad < maximo) {
            saldo += cantidad;
            System.out.println( "Ingreso de " + cantidad + "€. Saldo actual: " + saldo + "€");
        }else{
            System.out.println("Ingreso máximo superado");
            fin = true;
        }

    }

    public synchronized void reintegro(int cantidad, String n) {
        System.out.println("\n"+n+"--intento de retirada de " + cantidad + "€");
        if(cantidad < saldo) {
            saldo -= cantidad;
            System.out.println( "Retirada de " + cantidad + "€. Saldo actual: " + saldo + "€");
        }else{
            System.out.println("Saldo insuficiente");
            fin = true;
        }

    }
}

