import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* Se recoge por teclado la ruta de un fichero y si existe y es fichero, se podrán realizar las siguientes opciones
        sobre ese fichero con flujos de byte, excepto opción 1 que se realizará leyendo bytes con Files: */


        Scanner t = new Scanner(System.in);
        int op = -1;
        String ruta;
        System.out.println("Introduce la ruta del archivo");
        ruta = t.nextLine();
        Path path = Path.of(ruta);
        File archivo = new File(path.toString());
        if(archivo.exists() && archivo.isFile()){
            do{
                System.out.println("""
                        
                        1.- Leer valores de bytes
                        2.- Leer valores como carácter
                        3.- Buscar byte
                        4.- Modificar byte
                        5.- Añadir byte
                        6.- Eliminar byte
                        0.- Salir
                        """);

                switch (op = Integer.parseInt(t.nextLine())){
                    case 1 ->{
                        // Se escriben en pantalla los valores de todos los bytes del fichero separados con un espacio.
                        try {
                            // leemos los bytes del archivo y los guardamos en un array de bytes
                            byte[] bytes = Files.readAllBytes(path);
                            // recorremos el array de bytes e imprimimos cada byte
                            for (byte b : bytes) {
                                System.out.print(b + " ");
                            }
                            System.out.println();
                        } catch (Exception e) {
                            System.out.println("Error al leer el archivo");
                        }
                    }
                    case 2 ->{
                        // Se escriben en pantalla los valores de todos los bytes del fichero interpretados como carácter.
                        InputStream lee = null;
                        try{
                            lee = new FileInputStream(archivo);
                            int byteLeido;
                            while((byteLeido = lee.read()) != -1){
                                System.out.print((char)byteLeido);
                            }
                            System.out.println();
                            lee.close();
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo");
                        } catch (Exception e) {
                            System.out.println("Error al cerrar el flujo");
                        }
                    }
                    case 3 ->{
                        // Se introduce por teclado el valor de un byte y se obtiene y se escribe en pantalla si el byte está contenido en el fichero y cuantas veces está en el fichero utilizando flujos de byte.
                        System.out.println("Introduce el byte a buscar");
                        byte byteBuscar = Byte.parseByte(t.nextLine());
                        int contador = 0;
                        InputStream lee = null;
                        try{
                            lee = new FileInputStream(archivo);
                            int byteLeido;
                            while((byteLeido = lee.read()) != -1){
                                if(byteLeido == byteBuscar){
                                    contador++;
                                }
                            }
                            if(contador > 0) {
                                System.out.println("El byte " + byteBuscar + " está en el archivo " + contador + " veces");
                            }else{
                                System.out.println("El byte " + byteBuscar + " no está en el archivo");
                            }

                            lee.close();
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo");
                        } catch (Exception e) {
                            System.out.println("Error al cerrar el flujo");
                        }

                    }
                    case 4 ->{
                        // Se introduce por teclado un valor1 de un byte y un nuevo valor2 y se sustituye en el fichero valor1 por valor2.
                        System.out.println("Introduce el byte a modificar");
                        byte byteModificar = Byte.parseByte(t.nextLine());
                        System.out.println("Introduce el nuevo byte");
                        byte nuevoByte = Byte.parseByte(t.nextLine());
                        InputStream lee = null;
                        try{
                            lee = new FileInputStream(archivo);
                            File output = new File(archivo.getAbsolutePath()+".tmp");
                            FileOutputStream escribe = new FileOutputStream(output);
                            int byteLeido;
                            while((byteLeido = lee.read()) != -1){
                                if(byteLeido == byteModificar){
                                    escribe.write(nuevoByte);
                                }else{
                                    escribe.write(byteLeido);
                                }
                            }
                            escribe.close();
                            lee.close();
                            if (!archivo.delete()) {
                                System.out.println("Error al eliminar el archivo original");
                            }
                            if (!output.renameTo(archivo)) {
                                System.out.println("Error al renombrar el archivo temporal");
                            }
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo");
                        } catch (Exception e) {
                            System.out.println("Error al cerrar el lee");
                        }
                    }
                    case 5 ->{
                        //Se introduce por teclado un valor de un byte y se añade ese byte al final del fichero.
                        System.out.println("Introduce el byte a añadir");
                        byte byteAnadir = Byte.parseByte(t.nextLine());
                        try{
                            FileOutputStream escribe = new FileOutputStream(archivo, true);
                            escribe.write(byteAnadir);
                            escribe.close();
                        } catch (IOException e) {
                            System.out.println("Error al añadir el byte");
                        }

                    }
                    case 6 ->{
                        // Se introduce por teclado el valor de un byte y se modifica el fichero eliminando ese byte dentro de su contenido
                        System.out.println("Introduce el byte a eliminar");
                        byte byteEliminar = Byte.parseByte(t.nextLine());
                        InputStream lee = null;
                        try{
                            lee = new FileInputStream(archivo);
                            File output = new File(archivo.getAbsolutePath()+".tmp");
                            FileOutputStream escribe = new FileOutputStream(output);
                            int byteLeido;
                            while((byteLeido = lee.read()) != -1){
                                if(byteLeido != byteEliminar) {
                                    escribe.write(byteLeido);
                                }
                            }
                            escribe.close();
                            lee.close();
                            if (!archivo.delete()) {
                                System.out.println("Error al eliminar el archivo original");
                            }
                            if (!output.renameTo(archivo)) {
                                System.out.println("Error al renombrar el archivo temporal");
                            }
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo");
                        } catch (Exception e) {
                            System.out.println("Error al cerrar el flujo");
                        }

                    }
                    case 0 ->{
                        System.out.println("Adios");
                    }
                    default ->{
                        System.out.println("Opción no válida");
                    }
                }
            }while (op != 0);
        }else if(!archivo.exists()) {
            System.out.println("El archivo no existe");
        }else if(!archivo.isFile()){
            System.out.println("La ruta no corresponde a un archivo");
        }
    }
}
