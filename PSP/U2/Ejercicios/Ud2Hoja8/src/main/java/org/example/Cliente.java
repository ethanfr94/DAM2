package org.example;

public class Cliente extends Thread{

    // Número de copas que puede tomar un cliente
    private static int COPAS = 5;
    // Fiesta a la que asiste el cliente
    private Fiesta fiesta;
    // Número del cliente
    private int numero;

    public Cliente( Fiesta fiesta, int numero)
    {
        this.fiesta = fiesta;
        this.numero = numero;
    }

    public void run()
    {
        try
        {
            // El cliente pide 5 copas
            for(int x = 0; x < COPAS; x++)
            {
                // El cliente pide una copa en la barra que menos cola tenga y espera a que le sirvan la copa para beberla y bailar un rato
                System.out.println("--------En la cola izquierda hay: "+fiesta.cola_barra_izq()+ " en la cola derecha hay: "+fiesta.cola_barra_der());
                if(fiesta.cola_barra_izq() < fiesta.cola_barra_der())
                {
                    fiesta.pedir_izq(numero);
                    fiesta.beber_izq(numero);
                }
                else
                {
                    fiesta.pedir_der(numero);
                    fiesta.beber_der(numero);
                }
                System.out.println("--------El cliente " + numero + " se pone a bailar.-");
                Thread.sleep((int)(Math.random() * 600) );

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
