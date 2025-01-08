import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
    El objetivo del ejercicio es crear una aplicación cliente/servidor usando sockets
    stream que permita el envío de ficheros al cliente. Para ello, el cliente se
    conectará al servidor por el puerto 1500 y le solicitará el nombre de un fichero del
    servidor. Si el fichero existe, el servidor, le enviará el fichero al cliente y este lo
    mostrará por pantalla. Si el fichero no existe, el servidor le enviará al cliente un
    mensaje de error. Una vez que el cliente ha mostrado el fichero se finalizará la
    conexión.
*/

public class Servidor {

    static final int PUERTO = 1500;

    public Servidor(){
        try{

            // Se crea el socket del servidor
            ServerSocket server = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando en puerto " + PUERTO);
            while (true) {
                // Se espera una conexión de un cliente
                Socket cliente = server.accept();
                // cliente.getInetAddress() devuelve la dirección IP del cliente
                System.out.println(" IP: " + cliente.getInetAddress());
                // Se envía un mensaje al cliente
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                // salida.writeUTF escribe un mensaje en el flujo de salida
                salida.writeUTF("Conectado correctamente");

                boolean ok = false;

                while (!ok) {
                    // Se recibe un mensaje del cliente
                    DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                    // guarda el nombre del archivo que el cliente quiere ver
                    String nombreArchivo = entrada.readUTF();
                    // imprime el nombre del archivo
                    System.out.println(nombreArchivo);
                    // convertir el nombre del archivo en un objeto Path
                    // para poder convertirlo en un archivo File y poder manipularlo
                    Path path = Path.of("src", nombreArchivo);
                    File file = new File(path.toString());
                    // se comprueba si el archivo existe
                    if (file.exists()) {
                        // con Files.readAllLines se lee el archivo y se guarda en una lista
                        List<String> mensaje = Files.readAllLines(path);
                        // se crea un string con el contenido del archivo
                        String msg = "";
                        for (String linea : mensaje) {
                            msg += linea + "\n";
                        }
                        // se envía el contenido del archivo al cliente
                        salida.writeUTF(msg);
                        // se cambia el valor de la variable para salir del bucle
                        ok = true;

                    } else {
                        // si el archivo no existe se envía un mensaje de error al cliente
                        salida.writeUTF("El archivo no existe");
                    }
                }

                // Se cierra la conexión con el cliente
                cliente.close();
            }

        } catch (EOFException e) {
            e.printStackTrace();
        } catch(RuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }

}
