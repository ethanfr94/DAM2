package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/*
EJERCICIO 4
Crea un programa con un menú como el siguiente:
1.- Comprobar si es directorio
2.- Obtener ficheros en directorio
3.- Obtener propiedades de fichero
4.- Obtener ruta del directorio actual
5.- Eliminar fichero
6.- Mover fichero
7.- Renombrar fichero
8.- Copiar fichero
9.- Ver/Crear directorio
0.- Salir

Y en función de la opción elegida realizar las acciones correspondientes teniendo en
cuenta que:

Opción 1: Se pide por teclado la ruta de un directorio y se responde si existe un objeto
con esa ruta y, en su caso, si es directorio.

Opción 2: Se pide por teclado la ruta del directorio y se listan en pantalla los ficheros y
subdirectorios que contiene. Después de cada nombre se escribe D o F según sea
subdirectorio o fichero.

Opción 3: Se pide por teclado la ruta de un fichero y se escribe en pantalla si existe, si
es fichero, su tamaño en bytes, si es de escritura y si es oculto.

Opción 4: Se debe escribir en pantalla la ruta absoluta del directorio actual de trabajo.

Opción 5: Se pide por teclado la ruta de un fichero y si existe se elimina. Si no existe,
se da un mensaje en pantalla.

Opción 6: Se pide por teclado la ruta de un fichero y, si existe, se mueve el fichero al
directorio que se indique por teclado. En el directorio destino tendrá el mismo nombre
que en el origen. Si ya existiera el fichero destino se reemplaza su contenido.

Opción 7: Se pide por teclado la ruta de un fichero y, si existe, se renombra el fichero
con el nombre que se dé por teclado. Si el nuevo nombre ya existe, se rechaza la
operación y se escribe un mensaje.

Opción 8: Se pide por teclado la ruta de un fichero y, si existe, se copia el fichero a otro
fichero destino cuya ruta se da por teclado. Si existe ya el fichero destino se reemplaza
su contenido.

Opción 9: Se pide el la ruta de un directorio y, si ya existe, se escribe su contenido y, si
no existe, se crea.
*/
public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("""
            
            1.- Comprobar si es directorio
            2.- Obtener ficheros en directorio
            3.- Obtener propiedades de fichero
            4.- Obtener ruta del directorio actual
            5.- Eliminar fichero
            6.- Mover fichero
            7.- Renombrar fichero
            8.- Copiar fichero
            9.- Ver/Crear directorio
            0.- Salir""");

            System.out.print("\nOpción: ");
            opcion = Integer.parseInt(t.nextLine());
            switch (opcion) {
                case 1-> {
                    System.out.println("Introduce la ruta del directorio: ");
                    String ruta = t.nextLine();
                    // creamos un objeto Path con la ruta del directorio
                    Path path = Path.of(ruta);
                    // comprobamos si existe el directorio
                    // Files.isDirectory devuelve true si es un directorio
                    if(Files.exists(path)) System.out.println("Es directorio: "+ Files.isDirectory(path));
                    else System.out.println("Ruta no válida");
                }
                case 2-> {
                    System.out.println("Introduce la ruta del directorio: ");
                    String ruta = t.nextLine();
                    // creamos un objeto Path con la ruta del directorio
                    Path path = Path.of(ruta);
                    // comprobamos si existe el directorio
                    if(Files.exists(path)) {
                        try{
                            // Files.list devuelve un Stream<Path> con los elementos del directorio
                            Stream<Path> paths = Files.list(path);
                            // Recorremos el Stream<Path> con forEach y mostramos si es un directorio o un fichero
                            paths.forEach(p -> {
                                // Files.isDirectory devuelve true si es un directorio
                                // Files.isRegularFile devuelve true si es un fichero
                                // p.getFileName() devuelve el nombre del fichero o directorio
                                if(Files.isDirectory(p)) System.out.println(p.getFileName()+" D");
                                else System.out.println(p.getFileName()+" F");
                            });
                        }catch (IOException e){
                            System.out.println("Error: "+e.getMessage());
                        }
                    }else System.out.println("Ruta no válida");
                }
                case 3-> {
                    System.out.println("Introduce la ruta del fichero: ");
                    String ruta = t.nextLine();
                    // creamos un objeto Path con la ruta del fichero
                    Path path = Path.of(ruta);
                    // comprobamos si existe el fichero
                    if(Files.exists(path)) {
                        try {
                            // Files.isRegularFile devuelve true si es un fichero
                            System.out.println("Es fichero: " + Files.isRegularFile(path));
                            // Files.size devuelve el tamaño del fichero en bytes
                            System.out.println("Tamaño: " + Files.size(path));
                            // Files.isWritable devuelve true si se puede escribir en el fichero
                            System.out.println("Escritura: " + Files.isWritable(path));
                            // Files.isHidden devuelve true si el fichero está oculto
                            System.out.println("Oculto: " + Files.isHidden(path));
                        }catch (IOException e){
                            System.out.println("Error: "+e.getMessage());
                        }
                    }else System.out.println("Ruta no válida");
                }
                case 4-> {
                    // System.getProperty("user.dir") devuelve la ruta del directorio actual
                    System.out.println("Ruta actual: "+System.getProperty("user.dir"));
                }
                case 5-> {
                    System.out.println("Introduce la ruta del fichero: ");
                    String ruta = t.nextLine();
                    // creamos un objeto Path con la ruta del fichero
                    Path path = Path.of(ruta);
                    // comprobamos si existe el fichero
                    try {
                        // Files.deleteIfExists elimina el fichero si existe
                        if (Files.deleteIfExists(path)) {
                            System.out.println("Fichero eliminado");
                        } else System.out.println("Ruta no válida");
                    }catch (IOException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                }
                case 6-> {
                    System.out.println("Introduce la ruta del fichero: ");
                    String ruta = t.nextLine();
                    // creamos un objeto Path con la ruta del fichero
                    Path path = Path.of(ruta);
                    // comprobamos si existe el fichero
                    if(Files.exists(path)) {
                        System.out.println("Introduce la ruta del directorio destino: ");
                        String destino = t.nextLine();
                        // creamos un objeto Path con la ruta del directorio destino
                        Path pathDestino = Path.of(destino);
                        try {
                            // Files.move mueve el fichero al directorio destino con el mismo nombre que en el origen
                            // path.getFileName() devuelve el nombre del fichero sin la ruta
                            // pathDestino.resolve añade la ruta del directorio destino al nombre del fichero
                            Files.move(path, pathDestino.resolve(path.getFileName()));
                            System.out.println("Fichero movido");
                        }catch (IOException e){
                            System.out.println("Error: "+e.getMessage());
                        }
                    }else System.out.println("Ruta no válida");
                }
                case 7-> {
                    System.out.println("Introduce la ruta del fichero: ");
                    String ruta = t.nextLine();
                    // creamos un objeto Path con la ruta del fichero
                    Path path = Path.of(ruta);
                    // comprobamos si existe el fichero
                    if(Files.exists(path)) {
                        System.out.println("Introduce el nuevo nombre: ");
                        String nuevoNombre = t.nextLine();
                        // creamos un objeto Path con la ruta del fichero con el nuevo nombre
                        // path.getParent() devuelve la ruta del directorio del fichero
                        // Path.of(path.getParent().toString(), nuevoNombre) crea un objeto Path con la ruta del directorio y el nuevo nombre

                        // para renombrar un fichero, hay que crear un nuevo objeto Path con el nuevo nombre
                        // y usar Files.move para mover el fichero al nuevo nombre

                        Path pathNuevo = Path.of(path.getParent().toString(), nuevoNombre);
                        try {
                            // Files.move renombra el fichero con el nuevo nombre
                            Files.move(path, pathNuevo);
                            System.out.println("Fichero renombrado");
                        }catch (IOException e){
                            System.out.println("Error: "+e.getMessage());
                        }
                    }else System.out.println("Ruta no válida");
                }
                case 8-> {
                    System.out.println("Introduce la ruta del directorio: ");
                    String ruta = t.nextLine();
                    // creamos un objeto Path con la ruta del directorio
                    Path path = Path.of(ruta);
                    if(Files.exists(path)) {
                        System.out.println("Introduce la ruta del fichero destino: ");
                        String destino = t.nextLine();
                        // creamos un objeto Path con la ruta del fichero destino
                        Path pathDestino = Path.of(destino);
                        try {
                            // Files.copy copia el fichero al fichero destino
                            // pathDestino.resolve añade la ruta del directorio destino al nombre del fichero
                            Files.copy(path, pathDestino.resolve(path.getFileName()));
                            System.out.println("Fichero copiado");
                        }catch (IOException e){
                            System.out.println("Error: "+e.getMessage());
                        }
                    } else{
                        System.out.println("Ruta no válida");
                    }
                }
                case 9-> {
                    System.out.println("Introduce la ruta del directorio: ");
                    String ruta = t.nextLine();
                    // creamos un objeto Path con la ruta del directorio
                    Path path = Path.of(ruta);
                    // comprobamos si existe el directorio
                    if(Files.exists(path)) {
                        try {
                            // Files.list devuelve un Stream<Path> con los elementos del directorio
                            Stream<Path> paths = Files.list(path);
                            // Recorremos el Stream<Path> con forEach y mostramos si es un directorio o un fichero
                            paths.forEach(p -> {
                                // Files.isDirectory devuelve true si es un directorio
                                // Files.isRegularFile devuelve true si es un fichero
                                // p.getFileName() devuelve el nombre del fichero o directorio
                                if(Files.isDirectory(p)) System.out.println(p.getFileName()+" D");
                                else System.out.println(p.getFileName()+" F");
                            });
                        }catch (IOException e){
                            System.out.println("Error: "+e.getMessage());
                        }
                    }else {
                        try {
                            // Files.createDirectory crea el directorio si no existe
                            Files.createDirectory(path);
                            System.out.println("Directorio creado");
                        }catch (IOException e){
                            System.out.println("Error: "+e.getMessage());
                        }
                    }
                }
                case 0-> {
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        } while (opcion != 0);

    }
}