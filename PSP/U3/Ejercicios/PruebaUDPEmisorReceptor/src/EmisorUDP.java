import java.io.IOException;
import java.net.*;

public class EmisorUDP {
    public static void main(String [] args) {
        // comprobar argumentos
        if(args.length != 2){
            System.err.println("Uso: java EmisorUDP maquina mensaje");
        }
        else try{
            // Crear el socket
            DatagramSocket sSocket = new DatagramSocket();
            // construye la dirección del receptor pasando por argumento la máquina destino
            InetAddress maquina = InetAddress.getByName(args[0]);
            int puerto = 1500;
            // construye el mensaje
            byte [] cadena = args[1].getBytes();
            DatagramPacket mensaje = new DatagramPacket(cadena, args[1].length(), maquina, puerto);
            // envía el mensaje
            sSocket.send(mensaje);
            // cierra el socket
            sSocket.close();
        }  catch(UnknownHostException e) {
            System.err.println("Desconocido: " + e.getMessage());
        } catch(SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch(IOException e) {
            System.err.println("E/S: " + e.getMessage());
        }

    }

}
