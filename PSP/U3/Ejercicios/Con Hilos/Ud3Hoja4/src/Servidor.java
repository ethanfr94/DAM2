import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

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
public class Servidor {

    static final int PUERTO = 2000;

    public static void main(String [] args){
        try{

            // Se crea el socket del servidor
            DatagramSocket server = new DatagramSocket(PUERTO);
            InetAddress ip = InetAddress.getByName("localhost");
            // Crea el espacio para los mensajes
            byte[] recibe = new byte[1000];
            DatagramPacket mensaje = new DatagramPacket(recibe, recibe.length);
            boolean fin = false;

            System.out.println("Servidor esperando mensajes en el puerto: "+PUERTO);

            do{
                // Recibe el mensaje
                server.receive(mensaje);
                // convierte el mensaje de byte a String
                String datos = new String(mensaje.getData(), 0, mensaje.getLength());
                String respuesta = "";
                if(datos.equalsIgnoreCase("como te llamas?")){
                    respuesta = "Me llamo Izan";
                }else if(datos.equalsIgnoreCase("cual es tu edad?")){
                    respuesta = "Tengo 30 años";
                }else if(datos.equalsIgnoreCase("fin")){
                    respuesta = "Fin de la conversación";
                }else{
                    respuesta = "No he entendido la pregunta";
                }
                // envia la respuesta convertida a byte
                byte[] enviar = respuesta.getBytes();
                // crea el paquete con la respuesta
                DatagramPacket respuestaPaquete = new DatagramPacket(enviar, enviar.length, ip, mensaje.getPort());
                // envia la respuesta
                server.send(respuestaPaquete);

            }while(!fin);

            // cuando se adivina el numero secreto se cierra el socket y se termina el programa
            server.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
