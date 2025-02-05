import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUdp {
    static final int PUERTO = 2000;


    public static void main(String [] args) {

        boolean fin = false;
        Scanner t = new Scanner(System.in);
        int intento = 1;
        DatagramSocket sSocket = null;
        do{
            System.out.println("Adivine el numero secreto (Intento: "+intento+")");

            try {
                String num = t.nextLine();

                // Crear el socket
                sSocket = new DatagramSocket();
                // construye la dirección del receptor pasando por argumento la máquina destino
                InetAddress maquina = InetAddress.getByName("localhost");
                // construye el mensaje
                byte[] cadena = num.getBytes();
                DatagramPacket mensaje = new DatagramPacket(cadena, num.length(), maquina, PUERTO);
                // envía el mensaje
                sSocket.send(mensaje);

                // Crea el espacio para los mensajes
                byte[] recibe = new byte[1000];
                //  crea el paquete con la respuesta
                DatagramPacket respuesta = new DatagramPacket(recibe, recibe.length);
                // Recibe el mensaje
                sSocket.receive(respuesta);
                // convierte el mensaje de byte a String
                String datos = new String(respuesta.getData(), 0, respuesta.getLength());


                if(datos.equals("Numero Correcto")) {
                    System.out.println(datos);
                    System.out.println("Felicidades, ha adivinado el numero secreto");
                    fin = true;
                }else{
                    System.out.println(datos);
                    intento++;
                }
            }  catch(IOException e) {
                System.err.println("E/S: " + e.getMessage());

            }catch (RuntimeException e) {
                e.printStackTrace();
            }
        }while(!fin);
            // cierra el socket
            sSocket.close();
    }

}
