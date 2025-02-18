package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import javax.print.Doc;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.client.model.Updates.addToSet;
import static com.mongodb.client.model.Updates.set;

public class Main {

    static MongoDatabase db;
    static MongoCollection<Document> collection;
    static MongoClient client;

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        Logger.getLogger("org.mongodb.driver").setLevel(Level.OFF);

        client = MongoClients.create("mongodb://10.0.22.74:3406");

        String nomBD = "geografia";
        String nomCol = "ccaa";

        if (existe(nomBD)) {
            db = client.getDatabase(nomBD);
            if (existeCol(nomCol)) {
                collection = db.getCollection(nomCol);

                int op = -1;

                do {

                    System.out.println("""
                            
                            1.- Obtener comunidades autónomas y capitales
                            2.- Obtener comunidades autónomas con habitantes comprendidos entre valores
                            3.- Obtener comunidades autónomas uniprovinciales.
                            4.- Obtener capitales de comunidad autónoma con más habitantes que
                            5.- Obtener comunidades autónomas sin fecha de estatuto
                            6.- Obtener provincias de comunidad autónoma
                            7.- Crear fichero JSON
                            0.- Salir
                            """);

                    op = Integer.parseInt(t.nextLine());

                    switch (op) {
                        case 1 -> {
                            /*
                                Se muestran los nombres de todas las comunidades autónomas y los de sus capitales con formato JSON.
                                Debes realizarlo con projection.
                            */
                            MongoCursor<Document> cursor;
                            // se utiliza el método projection para indicar los campos que se quieren mostrar y no cargar toda la información
                            cursor = collection.find()
                                    .projection(fields(include("nombre", "capital"), exclude("_id")))
                                    .iterator();
                            while (cursor.hasNext()) {
                                Document doc = cursor.next();
                                System.out.println(doc.toJson());
                            }
                        }
                        case 2 -> {
                            /*
                                Se pide por teclado un valor mínimo de habitantes y un valor máximo y se escriben
                                en pantalla en mayúsculas los nombres y habitantes de las comunidades autónomas que
                                tienen un número de habitantes comprendido entre los anteriores. No hace falta comprobar
                                que el mínimo es menor que el máximo.
                                Se debe realizar con un filtro and que opera con los filtros lt y gt.
                                El listado debe salir ordenado por habitantes descendentemente.
                            */
                            System.out.println("Introduce el número mínimo de habitantes: ");
                            int min = Integer.parseInt(t.nextLine());
                            System.out.println("Introduce el número máximo de habitantes: ");
                            int max = Integer.parseInt(t.nextLine());

                            MongoCursor<Document> cursor;//
                            // creamos un filtro usaando expresiones de filtro Bson con Filters
                            Bson filter = Filters.and(Filters.gt("habitantes", min), Filters.lt("habitantes", max));
                            cursor = collection.find(filter).sort(descending("habitantes")).iterator();
                            // se puede encadenar ordenaciones con un .sort y una vez se cierra añadir otro .sort

                            while (cursor.hasNext()) {
                                Document doc = cursor.next();
                                System.out.println(doc.toJson());
                            }
                        }
                        case 3 -> {
                            /*
                                Se escriben en pantalla los nombres de todas las comunidades autónomas que tienen una sola
                                provincia en el atributo array provincias.
                            */

                            MongoCursor<Document> cursor;
                            // creamos un filtro que comprueba que el tamaño del array provincias sea 1
                            Bson filter = Filters.size("provincias", 1);

                            cursor = collection.find(filter).iterator();

                            while (cursor.hasNext()) {
                                Document doc = cursor.next();
                                System.out.println(doc.toJson());
                            }
                        }
                        case 4 -> {
                            /*
                                Se pide por teclado un número de habitantes y se escriben en pantalla los nombres de capitales
                                de comunidades autónomas que tienen más habitantes que los que se hayan introducido por teclado.
                                El listado debe estar ordenado alfabéticamente por nombres de las capitales.
                                Para extraer los datos de cada subdocumento capital tendrás que obtenerlo previamente con el método
                                get de cada Document de una comunidad autónoma.
                            */

                            System.out.println("Introduce el número de habitantes: ");
                            int habitantes = Integer.parseInt(t.nextLine());

                            MongoCursor<Document> cursor;
                            // creamos un filtro que comprueba que el número de habitantes sea mayor que el introducido
                            Bson filter = Filters.gt("capital.habitantes", habitantes);

                            cursor = collection.find(filter).sort(ascending("capital.nombre")).iterator();

                            while (cursor.hasNext()) {
                                Document doc = cursor.next();
                                System.out.println(doc.get("capital", Document.class).getString("nombre"));
                            }
                        }
                        case 5 -> {
                            /*
                                Se escriben en pantalla los nombres de todas las comunidades autónomas que no tienen atributo
                                fecha_estatuto o que lo tienen a valor nulo.Se escriben en pantalla los nombres de todas las comunidades autónomas que no tienen fecha de estatuto.
                            */
                            MongoCursor<Document> cursor;
                            // creamos un filtro que comprueba que el campo fecha_estatuto no existe o es nulo
                            Bson filter = Filters.or(Filters.exists("fecha_estatuto", false), Filters.eq("fecha_estatuto", null));

                            cursor = collection.find(filter).iterator();

                            while (cursor.hasNext()) {
                                Document doc = cursor.next();
                                System.out.println(doc.toJson());
                            }
                        }
                        case 6 -> {
                            /*
                                Se pide por teclado el nombre de una comunidad autónoma y se escriben en pantalla los nombres de sus provincias.
                                Si la comunidad autónoma no existe se escribe un mensaje de error.Se pide por teclado el código de una comunidad autónoma y, si existe, se escribe
                                en pantalla su nombre y los nombres de sus provincias (uno en cada línea)
                             */
                            System.out.println("Introduce el nombre de la comunidad autónoma: ");
                            String ccaa = t.nextLine();

                            MongoCursor<Document> cursor;
                            // creamos un filtro que comprueba que el campo nombre sea igual al introducido
                            Bson filter = Filters.eq("nombre", ccaa);

                            cursor = collection.find(filter).iterator();

                            if (cursor.hasNext()) {
                                Document doc = cursor.next();
                                List<String> provincias = doc.getList("provincias", String.class);
                                System.out.println("Provincias de " + ccaa + ": ");
                                for (String provincia : provincias) {
                                    System.out.println(provincia);
                                }
                            } else {
                                System.out.println("Comunidad autónoma no encontrada.");
                            }
                        }
                        case 7 -> {
                            /*
                                Se graba un fichero de texto, cuya ruta y nombre se dan por teclado, el JSON correspondiente a la consulta de todas
                                las comunidades autónomas con los atributos nombre, capital, provincias, habitantes, extension.
                                Investiga como hacer que la salida JSON del método toJson represente cada atributo en una línea y con indentación o sangrado.
                             */
                            System.out.println("Introduce ruta del fichero: ");
                            String ruta = t.nextLine();
                            System.out.println("Introduce nombre del fichero: ");
                            String nombre = t.nextLine();

                            nombre += ".txt";

                            Path path = Paths.get(ruta, nombre);

                            MongoCursor<Document> cursor;
                            cursor = collection.find().projection(fields(include("nombre", "capital", "provincias", "habitantes", "extension"), exclude("_id"))).iterator();

                            JsonWriterSettings settings = JsonWriterSettings.builder()
                                    .indent(true)
                                    .build();

                            List<Document> docs = new ArrayList<>();
                            while (cursor.hasNext()) {
                                Document doc = cursor.next();
                                docs.add(doc);
                                System.out.println(doc.toJson(settings));
                            }

                            try {
                                // Crear el fichero si no existe
                                if (!Files.exists(path)) {
                                    Files.createFile(path);
                                }

                                // Escribir en el fichero con formato JSON en una sola línea
                                Files.write(path, docs.toString().getBytes());

                                // Escribir en el fichero con formato JSON sangrado e indentado
                                /*docs.forEach(doc -> {
                                    try {
                                        Files.write(path, doc.toJson(settings).getBytes(), StandardOpenOption.APPEND);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });*/

                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                        }
                        case 0 -> {
                            System.out.println("Saliendo...");
                        }
                        default -> System.out.println("Opción no válida.");
                    }

                } while (op != 0);

            } else {
                System.out.println("Colección " + nomCol + " no encontrada.");
            }
        } else {
            System.out.println("Base de datos " + nomBD + " no encontrada.");
        }

    }

    private static boolean existe(String nomBD) {
        var iterDBs = client.listDatabaseNames().iterator();
        boolean existe = false;
        while (iterDBs.hasNext()) {
            if (iterDBs.next().equals(nomBD)) {
                existe = true;
            }
        }
        return existe;
    }

    private static boolean existeCol(String nomCol) {
        MongoCursor<String> iterCols = db.listCollectionNames().iterator();
        boolean existe = false;
        while (iterCols.hasNext()) {
            if (iterCols.next().equals(nomCol)) {
                existe = true;
            }
        }
        return existe;
    }

}