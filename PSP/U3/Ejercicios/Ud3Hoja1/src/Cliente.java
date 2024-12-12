import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    static final String HOST = "localhost";
    static final int PUERTO = 5000;

    public Cliente() {
        try {

            // Se crea el socket del cliente
            Socket cliente = new Socket(HOST, PUERTO);
            // Se recibe un mensaje del servidor
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            // Se imprime el mensaje recibido
            System.out.println(entrada.readUTF());
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

