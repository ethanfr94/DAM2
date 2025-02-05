import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

public class ServidorUdp extends Thread {

    static final int PUERTO = 2000;
    private InetAddress ip;
    private int n;
    private DatagramPacket mensaje;
    private DatagramSocket server;

    public ServidorUdp(DatagramSocket server, DatagramPacket mensaje, InetAddress ip, int n){
        this.server = server;
        this.mensaje = mensaje;
        this.ip = ip;
        this.n = n;
    }

    public void run(){
        boolean correcto = false;
        String res = "";
        try{
            while(!correcto){
                // Recibe el mensaje
                server.receive(mensaje);
                // convierte el mensaje de byte a String
                String datos = new String(mensaje.getData(), 0, mensaje.getLength());
                // convierte el String a int
                int numero = Integer.parseInt(datos);
                if(numero == n){
                    res = "Numero Correcto";
                    correcto = true;
                }else if(numero > n){
                    res = "numero Incorrecto, el numero secreto es menor";
                }else{
                    res = "numero Incorrecto, el numero secreto es mayor";
                }
                // envia la respuesta convertida a byte
                byte[] enviar = res.getBytes();
                // crea el paquete con la respuesta
                DatagramPacket respuesta = new DatagramPacket(enviar, enviar.length, ip, mensaje.getPort());
                // envia la respuesta
                server.send(respuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String [] args) {
        int n = (int)(Math.random()*100)+1;
        String num = Integer.toString(n);
        System.out.println("Numero generado: " + num);
        try{
            // Se crea el socket del servidor
            DatagramSocket server = new DatagramSocket(PUERTO);
            InetAddress ip = InetAddress.getByName("localhost");
            // Crea el espacio para los mensajes
            byte[] recibe = new byte[1000];
            DatagramPacket mensaje = new DatagramPacket(recibe, recibe.length);
            System.out.println("Esperando mensajes..");

            new ServidorUdp(server, mensaje, ip, n).start();

            // cuando se adivina el numero secreto se cierra el socket y se termina el programa
            // server.close();

        }catch (IOException e) {
            e.printStackTrace();
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

}
