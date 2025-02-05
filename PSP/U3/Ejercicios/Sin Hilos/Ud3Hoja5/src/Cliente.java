import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

    static final int PUERTO = 2000;

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        DatagramSocket cliente = null;

        System.out.print("Nombre:");
        String nombre = t.nextLine();
        System.out.print("Edad:");
        int edad = Integer.parseInt(t.nextLine());
        System.out.print("DNI:");
        String DNI = t.nextLine();

        Persona p = new Persona(nombre, edad, DNI);
        p.setRegistro(0);

        try {
            // Crear el socket
            cliente = new DatagramSocket();
            // construye la dirección del receptor pasando por argumento la máquina destino
            InetAddress maquina = InetAddress.getByName("localhost");
            // Crea el espacio para los mensajes
            byte[] envia;
            // Crea el espacio para los mensajes
            byte[] recibe = new byte[1000];

            // Creamos un objeto para serializar el objeto Persona en un array de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            // Serializamos el objeto Persona
            oos.writeObject(p);
            envia = baos.toByteArray();

            // construye el mensaje
            DatagramPacket mensaje = new DatagramPacket(envia, envia.length, maquina, PUERTO);
            // envía el mensaje
            cliente.send(mensaje);


            //  crea el paquete con la respuesta
            DatagramPacket respuesta = new DatagramPacket(recibe, recibe.length);
            // Recibe el mensaje
            cliente.receive(respuesta);

            // Creamos un objeto para deserializar el array de Bytes en un objeto Persona
            ByteArrayInputStream bais = new ByteArrayInputStream(respuesta.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);

            // Deserializamos el objeto Persona
            p = (Persona) ois.readObject();
            System.out.println(p.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        // cierra el socket
        cliente.close();
    }

}
