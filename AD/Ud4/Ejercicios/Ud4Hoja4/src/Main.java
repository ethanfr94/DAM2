import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
        do{
            System.out.println("""
                    1 Leer Contenido1
                    2 Leer Contenido2
                    3 Eliminar ciudad
                    4 Obtener ciudades de país
                    5 Añadir ciudad
                    6 Asignar localización
                    0 Salir
                    """);
            op = t.nextInt();
            switch (op){
                case 1->{
                    /* Opción 1: Obtiene una lista de objetos City con los datos de las ciudades con más de
                    200000 habitantes y escribe en pantalla los datos de esas ciudades. */

                    try{
                        List<City> cities = new ArrayList<>();
                        BufferedReader br = Files.newBufferedReader(path);
                        String line = br.readLine();
                        while((line = br.readLine()) != null){
                            String[] data = line.split(",");
                            if(Integer.parseInt(data[3]) > 200000){

                                if (data[4].equals("NULL")){
                                    data[4] = null;
                                }
                                if (data[5].equals("NULL")){
                                    data[5] = null;
                                }
                                City city = new City();
                                city.setName(data[0]);
                                city.setCountry(data[1]);
                                city.setProvince(data[2]);
                                if(data[3].equals("NULL")) {
                                    city.setPopulation(0);
                                }else{
                                    city.setPopulation(Integer.parseInt(data[3]));
                                }
                                cities.add(city);
                            }
                        }
                        cities.forEach(city -> city.toString());
                    }catch (Exception e){
                        e.printStackTrace();
                    }


                }
                case 2->{
                    /* Opción 2: Obtiene una lista de objetos City con los datos de las ciudades que no tienen
                    registrada localización en latitud y escribe en pantalla el nombre de esas ciudades y el
                    código del país al que pertenecen. */

                }
                case 3->{
                    /* Opción 3: Pide por teclado el nombre de una ciudad y el código del país al que
                    pertenece y la elimina del fichero. */

                }
                case 4->{
                    /* Opción 4: Pide por teclado el código de un país y escribe en pantalla los datos de las
                    ciudades de ese país. */

                }
                case 5->{
                    /* Opción 5: Pide por teclado el código de un país y los datos nombre, provincia y habitantes
                    de la ciudad y la inserta dentro del fichero en orden alfabético. */

                }
                case 6->{
                    /* Opción 6: Pide por teclado el nombre de una ciudad y el código del país al que pertenece
                    y, si existe y tiene la localización a nulo, le asigna a la localización los valores que se
                    introduzcan por teclado. */

                }
                case 0->{
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opción no válida");
            }

        }while(op != 0);

    }
}
