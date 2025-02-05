import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor extends Thread {

    static final int PUERTO = 2000;
    private static int registro = 1;
    private byte[] recibe;
    private byte[] envia;
    private DatagramSocket server;

    public Servidor(byte[] recibe, byte[] envia, DatagramSocket server){
        this.recibe = recibe;
        this.envia = envia;
        this.server = server;
    }

    public void run(){
        try{
            while (true) {

                // Recibe el mensaje
                DatagramPacket llegada = new DatagramPacket(recibe, recibe.length);
                server.receive(llegada);

                // convierte el mensaje de byte a Persona
                ByteArrayInputStream bais = new ByteArrayInputStream(llegada.getData());
                ObjectInputStream ois = new ObjectInputStream(bais);

                // Deserializamos el objeto Persona
                Persona p = (Persona) ois.readObject();
                System.out.println("Recibido: "+p.toString());

                p.setRegistro(registro++);

                // Creamos un objeto para serializar el objeto Persona en un array de bytes
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);

                // Serializamos el objeto Persona
                oos.writeObject(p);
                envia = baos.toByteArray();

                // crea el paquete con la respuesta
                DatagramPacket respuesta = new DatagramPacket(envia, envia.length, llegada.getAddress(), llegada.getPort());
                server.send(respuesta);

                System.out.println("Enviado: "+p.toString());

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        try{

            // Se crea el socket del servidor
            DatagramSocket server = new DatagramSocket(PUERTO);
            // Crea el espacio para los mensajes
            byte[] recibe = new byte[1000];
            byte[] envia = null;

            DatagramPacket mensaje = new DatagramPacket(recibe, recibe.length);

            System.out.println("Servidor esperando mensajes en el puerto: "+PUERTO);

            new Servidor(recibe, envia, server).start();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
