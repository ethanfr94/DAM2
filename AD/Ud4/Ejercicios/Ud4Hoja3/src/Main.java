import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            /*
            Realiza un programa que actúa sobre un fichero de texto fichero_tarea3.json y que
            realiza las siguientes operaciones:
            El programa presenta un menú como el siguiente y realiza las siguientes operaciones
            excepto la primera leyendo el fichero, línea a línea :
            1 Leer Contenido1
            2 Leer Contenido2
            3 Reemplazar texto
            4 Modificar línea
            5 Eliminar línea
            6 Añadir línea
            0 Salir
            Y en función de la opción elegida realiza el proceso correspondiente.
            */

        Path path = Paths.get("fichero_tarea_3.json");

        File archivo = new File(path.toString());

        if(archivo.exists()) {
            Scanner t = new Scanner(System.in);
            int op = -1;

            do {
                System.out.println("""
                        
                        1 Leer Contenido1
                        2 Leer Contenido2
                        3 Reemplazar texto
                        4 Modificar línea
                        5 Eliminar línea
                        6 Añadir línea
                        0 Salir
                        """);
                op = Integer.parseInt(t.nextLine());
                switch (op) {
                    case 1 -> {
                        /* Opción 1: Leyendo el fichero con un método de Files, recoger por teclado una palabra y
                            escribir en pantalla todas las líneas que contienen la palabra. */
                        try {
                            List<String> texto = Files.readAllLines(path);
                            System.out.println("Introduce una palabra");
                            String palabra = t.nextLine();
                            for (String linea : texto) {
                                if (linea.contains(palabra)) {
                                    System.out.println(linea);
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo");
                        }
                    }
                    case 2 -> {
                        /* Opción 2: Se recoge por teclado una palabra y se escriben en pantalla todas las líneas
                            que contienen la palabra. Cada línea estará precedida del número de línea en el fichero. */
                        try {
                            List<String> texto = Files.readAllLines(path);
                            System.out.println("Introduce una palabra");
                            String palabra = t.nextLine();
                            for(int i = 0; i < texto.size(); i++){
                                if(texto.get(i).contains(palabra)){
                                    System.out.println(i + " " + texto.get(i));
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo");
                        }

                        /* Con BufferedReader
                            try{
                                // creamos un BufferedReader para leer el archivo y le pasamos el path del archivo
                                BufferedReader br = Files.newBufferedReader(path);
                                System.out.println("Introduce una palabra");
                                String palabra = t.nextLine();
                                String linea;
                                int numLinea = 0;
                                // leemos el archivo linea a linea
                                while((linea = br.readLine()) != null){
                                    if(linea.contains(palabra)){
                                        System.out.println(numLinea + " " + linea);
                                    }
                                    numLinea++;
                                }
                                br.close();
                            } catch (IOException e) {
                                System.out.println("Error al leer el archivo");
                            }
                        */
                    }
                    case 3 -> {
                        /* Opción 3: Se recoge por teclado un texto y se sustituyen en el fichero todas las
                            apariciones de ese texto por otro texto introducido por teclado. */
                        try {
                            // leemos el archivo y guardamos las lineas en una lista
                            List<String> texto = Files.readAllLines(path);
                            System.out.println("Introduce texto a modificar");
                            String palabra1 = t.nextLine();
                            System.out.println("Introduce nuevo texto");
                            String palabra2 = t.nextLine();
                            for(int i = 0; i < texto.size(); i++){
                                if(texto.get(i).contains(palabra1)){
                                    // texto.set modifica el texto en la posicion i
                                    // replace reemplaza la palabra1 por la palabra2
                                    // i es la posicion de la linea en la lista
                                    texto.set(i, texto.get(i).replace(palabra1, palabra2));
                                }
                            }
                            // escribimos el texto modificado en el archivo haciendo qie lo que habia antes se borre
                            Files.write(path, texto);
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo");
                        }

                        /* Con BufferedReader
                            try{
                                // creamos un BufferedReader para leer el archivo y le pasamos el path del archivo
                                BufferedReader br = Files.newBufferedReader(path);
                                System.out.println("Introduce texto a modificar");
                                String palabra1 = t.nextLine();
                                System.out.println("Introduce nuevo texto");
                                String palabra2 = t.nextLine();
                                String linea;
                                // creamos un StringBuilder para guardar el texto modificado
                                String texto = "";
                                // leemos el archivo linea a linea
                                while((linea = br.readLine()) != null){
                                    if(linea.contains(palabra1)){
                                        // reemplazamos la palabra1 por la palabra2
                                        texto += linea.replace(palabra1, palabra2);
                                    }else{
                                        texto += linea;
                                    }
                                }
                                br.close();
                                // escribimos el texto modificado en el archivo
                                Files.write(path, texto.getBytes());
                            } catch (IOException e) {
                                System.out.println("Error al leer el archivo");
                            }
                         */
                    }
                    case 4 -> {
                        /* Opción 4: Se recoge por teclado un número de línea del fichero, se escribe en pantalla
                            el texto de esa línea (si existe) y se sustituye el contenido de esa línea por otro
                            introducido por teclado. */
                        try{
                            List<String> texto = Files.readAllLines(path);
                            System.out.println("Introduce el número de línea");
                            int numLinea = Integer.parseInt(t.nextLine());
                            if(numLinea >= 0 && numLinea < texto.size()){
                                System.out.println(texto.get(numLinea));
                                System.out.println("Introduce el nuevo texto");
                                String nuevoTexto = t.nextLine();
                                texto.set(numLinea, nuevoTexto);
                                Files.write(path, texto);
                            }else{
                                System.out.println("Número de línea no válido");
                            }
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo");
                        }

                        /* Con BufferedReader
                            try{
                                // creamos un BufferedReader para leer el archivo y le pasamos el path del archivo
                                BufferedReader br = Files.newBufferedReader(path);
                                System.out.println("Introduce el número de línea");
                                int numLinea = Integer.parseInt(t.nextLine());
                                String linea;
                                int numLineaActual = 0;
                                String texto = "";
                                // leemos el archivo linea a linea
                                while((linea = br.readLine()) != null){
                                    if(numLineaActual == numLinea){
                                        System.out.println(linea);
                                        System.out.println("Introduce el nuevo texto");
                                        String nuevoTexto = t.nextLine();
                                        texto += nuevoTexto + "\n";
                                    }else{
                                        texto += linea + "\n";
                                    }
                                    numLineaActual++;
                                }
                                br.close();
                                // escribimos el texto modificado en el archivo
                                Files.write(path, texto.getBytes());
                            } catch (IOException e) {
                                System.out.println("Error al leer el archivo");
                            }
                         */
                    }
                    case 5 -> {
                        /* Opción 5: Se recoge por teclado un número de línea del fichero, se escribe en pantalla
                            el texto de esa línea (si existe) y se elimina del fichero. */
                        try{
                            List<String> texto = Files.readAllLines(path);
                            System.out.println("Introduce el número de línea");
                            int numLinea = Integer.parseInt(t.nextLine());
                            if(numLinea >= 0 && numLinea < texto.size()){
                                System.out.println(texto.get(numLinea));
                                texto.remove(numLinea);
                                Files.write(path, texto);
                            }else{
                                System.out.println("Número de línea no válido");
                            }
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo");
                        }

                        /* Con BufferedReader
                            try{
                                // creamos un BufferedReader para leer el archivo y le pasamos el path del archivo
                                BufferedReader br = Files.newBufferedReader(path);
                                System.out.println("Introduce el número de línea");
                                int numLinea = Integer.parseInt(t.nextLine());
                                String linea;
                                int numLineaActual = 0;
                                String texto = "";
                                // leemos el archivo linea a linea
                                while((linea = br.readLine()) != null){
                                    if(numLineaActual == numLinea){
                                        System.out.println(linea);
                                    }else{
                                        texto += linea + "\n";
                                    }
                                    numLineaActual++;
                                }
                                br.close();
                                // escribimos el texto modificado en el archivo
                                Files.write(path, texto.getBytes());
                            } catch (IOException e) {
                                System.out.println("Error al leer el archivo");
                            }
                         */
                    }
                    case 6 -> {
                        /* Opción 6: Se recoge por teclado un texto y se añade como nueva línea al final del
                            fichero */
                        try{
                            List<String> texto = Files.readAllLines(path);
                            System.out.println("Introduce el texto a añadir");
                            String nuevoTexto = t.nextLine();
                            texto.add(nuevoTexto);
                            Files.write(path, texto);
                        } catch (IOException e) {
                            System.out.println("Error al leer el archivo");
                        }

                        /* Con BufferedReader
                            try{
                                // creamos un BufferedReader para leer el archivo y le pasamos el path del archivo
                                BufferedReader br = Files.newBufferedReader(path);
                                System.out.println("Introduce el texto a añadir");
                                String nuevoTexto = t.nextLine();
                                String linea;
                                String texto = "";
                                // leemos el archivo linea a linea
                                while((linea = br.readLine()) != null){
                                    texto += linea + "\n";
                                }
                                br.close();
                                texto += nuevoTexto + "\n";
                                // escribimos el texto modificado en el archivo
                                Files.write(path, texto.getBytes());
                            } catch (IOException e) {
                                System.out.println("Error al leer el archivo");
                            }
                         */
                    }
                    case 0 -> {
                        System.out.println("Saliendo...");
                    }
                    default -> {
                        System.out.println("Opción no válida");
                    }
                }
            } while (true);
        }else{
            System.out.println("El archivo no existe");
        }
    }
}
