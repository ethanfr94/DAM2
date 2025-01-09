import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
 Escribe un programa que conteste a preguntas.
El programa creará sockets datagram y esperará conexiones. Cuando llegue una
conexión, leerá los mensajes recibidos.
• Si la frase es “como te llamas”, responderá con una cadena de texto que
indique vuestro nombre.
• Si la frase es “cuál es tu edad”, responderá con vuestra edad.
• Si la frase es cualquier otra cosa, responderá “No he entendido la pregunta”
Escribe un programa cliente que haga preguntas al servidor para verificar su
funcionamiento.
Finalizará cuando el cliente envíe la palabra “fin
*/
public class Cliente {
    static final int PUERTO = 2000;

    public static void main(String [] args){
        String pregunta;
        Scanner t = new Scanner(System.in);
        DatagramSocket cliente = null;

        do {

            System.out.print("Realizar pregunta:");
            pregunta = t.nextLine();

            try{

                // Crear el socket
                cliente = new DatagramSocket();
                // construye la dirección del receptor pasando por argumento la máquina destino
                InetAddress maquina = InetAddress.getByName("localhost");
                // construye el mensaje
                byte[] cadena = pregunta.getBytes();
                DatagramPacket mensaje = new DatagramPacket(cadena, pregunta.length(), maquina, PUERTO);
                // envía el mensaje
                cliente.send(mensaje);

                // Crea el espacio para los mensajes
                byte[] recibe = new byte[1000];
                //  crea el paquete con la respuesta
                DatagramPacket respuesta = new DatagramPacket(recibe, recibe.length);
                // Recibe el mensaje
                cliente.receive(respuesta);
                // convierte el mensaje de byte a String
                String datos = new String(respuesta.getData(), 0, respuesta.getLength());
                System.out.println(datos);


            }catch(Exception e){
                e.printStackTrace();
            }

        }while(!pregunta.equalsIgnoreCase("fin"));

        // cierra el socket
        cliente.close();
    }
}
