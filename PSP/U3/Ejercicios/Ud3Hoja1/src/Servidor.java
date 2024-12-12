import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    static final int PUERTO = 5000;
    private int clientes = 0;

    public Servidor(){
        try{

            // Se crea el socket del servidor
            ServerSocket server = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando en puerto " + PUERTO);
            while (true) {
                // Se espera una conexión de un cliente
                Socket cliente = server.accept();
                // se incrementa el número de clientes
                clientes++;
                // cliente.getInetAddress().getHostAddress() devuelve la dirección IP del cliente
                System.out.println("Cliente " + clientes + " IP: " + cliente.getInetAddress().getHostAddress());
                // Se envía un mensaje al cliente
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                salida.writeUTF("Hola cliente nº" + clientes);
                // Se cierra la conexión con el cliente
                cliente.close();
            }

        }catch(RuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }

}
