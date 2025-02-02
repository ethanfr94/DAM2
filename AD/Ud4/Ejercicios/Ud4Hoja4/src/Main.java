import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        El fichero city.csv es un fichero CSV cuya primera línea tiene los nombres de los
        campos del fichero CSV y el resto de las líneas contienen datos de ciudades. En los
        campos en los que se ha representado valor nulo, se ha hecho grabando el texto NULL.

        Modificar el programa para que trabaje con el mismo fichero tras eliminarle la línea de
        cabeceras.
         */

        Scanner t = new Scanner(System.in);
        Path path = Paths.get("city.csv");
        File file = new File(path.toString());
        int op = -1;
        do {
            System.out.println("""
                    
                    1 Leer Contenido1
                    2 Leer Contenido2
                    3 Eliminar ciudad
                    4 Obtener ciudades de país
                    5 Añadir ciudad
                    6 Asignar localización
                    0 Salir
                    """);
            op = Integer.parseInt(t.nextLine());
            switch (op) {
                case 1 -> {
                    /* Opción 1: Obtiene una lista de objetos City con los datos de las ciudades con más de
                    200000 habitantes y escribe en pantalla los datos de esas ciudades. */

                    try {
                        List<City> cities = new ArrayList<>();
                        BufferedReader br = Files.newBufferedReader(path);
                        String line = br.readLine();
                        while ((line = br.readLine()) != null) {
                            String[] data = line.split(",");
                            int pob;
                            if (data[3].equals("NULL")) {
                                pob = 0;
                            } else {
                                pob = Integer.parseInt(data[3]);
                            }
                            if (pob > 200000) {

                                if (data[4].equals("NULL")) {
                                    data[4] = null;
                                }
                                if (data[5].equals("NULL")) {
                                    data[5] = null;
                                }
                                City city = new City();
                                city.setName(data[0]);
                                city.setCountry(data[1]);
                                city.setProvince(data[2]);
                                city.setPopulation(pob);
                                cities.add(city);
                            }
                        }
                        cities.forEach(city ->
                                System.out.println(city.toString())
                        );

                        System.out.println("\nHay "+cities.size()+" ciudades con más de 200000 habitantes");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
                case 2 -> {
                    /* Opción 2: Obtiene una lista de objetos City con los datos de las ciudades que no tienen
                    registrada localización en latitud y escribe en pantalla el nombre de esas ciudades y el
                    código del país al que pertenecen. */

                    try {
                        List<City> cities = new ArrayList<>();
                        BufferedReader br = Files.newBufferedReader(path);
                        String line = br.readLine();
                        while ((line = br.readLine()) != null) {
                            String[] data = line.split(",");
                            int pob;
                            if (data[3].equals("NULL")) {
                                pob = 0;
                            } else {
                                pob = Integer.parseInt(data[3]);
                            }
                            if (data[4].equals("NULL") || data[5].equals("NULL")) {

                                if (data[4].equals("NULL")) {
                                    data[4] = null;
                                }
                                if (data[5].equals("NULL")) {
                                    data[5] = null;
                                }
                                City city = new City();
                                city.setName(data[0]);
                                city.setCountry(data[1]);
                                city.setProvince(data[2]);
                                city.setPopulation(pob);
                                cities.add(city);
                            }
                        }
                        cities.forEach(city ->
                                System.out.printf("Ciudad: %-30s País: %-10s%n", city.getName(), city.getCountry())
                        );

                        System.out.println("\nHay "+cities.size()+" ciudades sin localización");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                case 3 -> {
                    /* Opción 3: Pide por teclado el nombre de una ciudad y el código del país al que
                    pertenece y la elimina del fichero. */

                    System.out.println("Introduce el nombre de la ciudad:");
                    String ciudad = t.nextLine();

                    System.out.println("Introduce el código del país:");
                    String pais = t.nextLine();

                    try {
                        // Leer el fichero
                        List<String> lines = Files.readAllLines(path);
                        if (!lines.isEmpty()) {
                            lines.remove(0);
                        }
                        for (int i = 0; i < lines.size(); i++) {
                            // seleccionar la línea
                            String line = lines.get(i);
                            // separar los datos de la línea en un array de Strings
                            String[] data = line.split(",");
                            // si el nombre y el país coinciden con los introducidos por teclado se elimina la línea
                            if (data[0].equalsIgnoreCase(ciudad) && data[1].equalsIgnoreCase(pais)) {
                                System.out.println("ciudad encontrada: "+data[0]+" "+data[1]);
                                lines.remove(i);
                                break;
                            }
                        }
                        // reescribir el fichero con las líneas restantes
                        Files.write(path, lines);
                        System.out.println("Ciudad eliminada");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                case 4 -> {
                    /* Opción 4: Pide por teclado el código de un país y escribe en pantalla los datos de las
                    ciudades de ese país. */

                    System.out.println("Introduce el código del país:");
                    String pais = t.nextLine();

                    try {
                        // Leer el fichero
                        System.out.println("Ciudades de "+pais.toUpperCase());
                        List<String> lines = Files.readAllLines(path);
                        if (!lines.isEmpty()) {
                            lines.remove(0);
                        }
                        for (int i = 0; i < lines.size(); i++) {
                            // seleccionar la línea
                            String line = lines.get(i);
                            // separar los datos de la línea en un array de Strings
                            String[] data = line.split(",");
                            // si el nombre y el país coinciden con los introducidos por teclado se elimina la línea
                            if (data[1].equalsIgnoreCase(pais)) {
                                System.out.println("Ciudad: "+data[0]);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                case 5 -> {
                    /* Opción 5: Pide por teclado el código de un país y los datos nombre, provincia y habitantes
                    de la ciudad y la inserta dentro del fichero en orden alfabético. */

                    System.out.println("Introduce el código del país:");
                    String pais = t.nextLine();
                    System.out.println("Introduce el nombre de la ciudad:");
                    String ciudad = t.nextLine();
                    System.out.println("Introduce la provincia:");
                    String provincia = t.nextLine();
                    System.out.println("Introduce la población:");
                    int poblacion = Integer.parseInt(t.nextLine());

                    try {
                        List<String> lines = Files.readAllLines(path);
                        if (!lines.isEmpty()) {
                            lines.remove(0);
                        }
                        String city = ciudad+","+pais+","+provincia+","+poblacion+",NULL,NULL";

                        int index = 0;
                        while (index < lines.size() && lines.get(index).split(",")[0].compareToIgnoreCase(ciudad) < 0) {
                            index++;
                        }
                        lines.add(index, city);
                        Files.write(path, lines);
                        System.out.println("Ciudad añadida");
                        // lo añade una posicion despues de donde deberia ir
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                case 6 -> {
                    /* Opción 6: Pide por teclado el nombre de una ciudad y el código del país al que pertenece
                    y, si existe y tiene la localización a nulo, le asigna a la localización los valores que se
                    introduzcan por teclado. */

                    System.out.println("Introduce el nombre de la ciudad:");
                    String ciudad = t.nextLine();

                    System.out.println("Introduce el código del país:");
                    String pais = t.nextLine();

                    try {
                        // Leer el fichero
                        List<String> lines = Files.readAllLines(path);
                        if (!lines.isEmpty()) {
                            lines.remove(0);
                        }
                        for (int i = 0; i < lines.size(); i++) {
                            // seleccionar la línea
                            String line = lines.get(i);
                            // separar los datos de la línea en un array de Strings
                            String[] data = line.split(",");
                            // si el nombre y el país coinciden con los introducidos por teclado se elimina la línea
                            if (data[0].equalsIgnoreCase(ciudad) && data[1].equalsIgnoreCase(pais) && data[4].equals("NULL") && data[5].equals("NULL")) {
                                System.out.println("ciudad encontrada: "+data[0]+" "+data[1]);
                                System.out.println("Introduce la latitud:");
                                double latitud = Double.parseDouble(t.nextLine());
                                System.out.println("Introduce la longitud:");
                                double longitud = Double.parseDouble(t.nextLine());
                                data[4] = String.valueOf(latitud);
                                data[5] = String.valueOf(longitud);
                                // String.join(",", data) une los elementos del array data con comas
                                lines.set(i, String.join(",", data));
                                Files.write(path, lines);
                                System.out.println("Localización asignada");
                                break;

                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                case 0 -> {
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opción no válida");
            }

        } while (op != 0);

    }
}
