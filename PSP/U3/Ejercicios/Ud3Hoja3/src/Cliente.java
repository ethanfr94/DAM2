import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
    El objetivo del ejercicio es crear una aplicación cliente/servidor usando sockets
    stream que permita el envío de ficheros al cliente. Para ello, el cliente se
    conectará al servidor por el puerto 1500 y le solicitará el nombre de un fichero del
    servidor. Si el fichero existe, el servidor, le enviará el fichero al cliente y este lo
    mostrará por pantalla. Si el fichero no existe, el servidor le enviará al cliente un
    mensaje de error. Una vez que el cliente ha mostrado el fichero se finalizará la
    conexión.
*/

public class Cliente {

    Scanner t = new Scanner(System.in);
    static final String HOST = "localhost";
    static final int PUERTO = 1500;

    public Cliente() {
        try {

            // Se crea el socket del cliente
            Socket cliente = new Socket(HOST, PUERTO);
            // Se recibe un mensaje del servidor
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            // Se imprime el mensaje recibido
            System.out.println(entrada.readUTF());
            // Se envia un nombre de archivo al servidor para ver si existe

            String mensaje;

            do {
                System.out.println("Introduce el nombre del archivo que deseas ver: ");
                String nombreArchivo = t.nextLine();
                nombreArchivo += ".txt";
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                salida.writeUTF(nombreArchivo);
                // Se recibe un mensaje del servidor
                System.out.println("Contenido del archivo: ");
                mensaje = entrada.readUTF();
                System.out.print(mensaje);
            }while (mensaje.equalsIgnoreCase("El archivo no existe"));

            // Se cierra la conexión con el servidor
            cliente.close();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cliente();
    }

}
