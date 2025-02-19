package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

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

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

public class Main {
    static MongoDatabase db;
    static MongoCollection<Document> colAlumnos;
    static MongoCollection<Document> colCursos;
    static MongoClient client;

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        Logger.getLogger("org.mongodb.driver").setLevel(Level.OFF);

        client = MongoClients.create("mongodb://10.0.22.74:3406");

        String nomBD = "formacion";
        String nomCol1 = "alumnos";
        String nomCol2 = "cursos";

        if (existe(nomBD)) {
            db = client.getDatabase(nomBD);
            if (existeCol(nomCol1)) {
                if(existeCol(nomCol2)) {
                    colAlumnos = db.getCollection(nomCol1);
                    colCursos = db.getCollection(nomCol2);

                    int op = -1;

                    do {

                        System.out.println("""
                                
                                1.- Añadir notas a alumnos de curso
                                2.- Añadir tema a curso
                                3.- Obtener alumnos de curso
                                4.- Número de alumnos por curso y media
                                5.- Modificar nota media de alumno
                                6.- Modificar horas de curso
                                7.- Datos de alumno
                                8.- Nota media en curso
                                9.- Subir nota media
                                0.- Salir
                                """);

                        op = Integer.parseInt(t.nextLine());

                        switch (op) {
                            case 1 -> {
                            /*
                                Se pide por teclado el id de un curso y, si existe, se va mostrando el nombre y apellidos
                                de cada uno de sus alumnos y se pide que se dé a cada uno una nota. La nota introducida
                                para cada alumno se añade al array de notas.

                            */
                                System.out.println("Introduce el id del curso: ");
                                String idCurso = t.nextLine();

                                Bson filtro = Filters.eq("curso", idCurso);
                                MongoCursor<Document> cursor = colCursos.find(eq(filtro)).iterator();

                                while(cursor.hasNext()){
                                    Document doc = cursor.next();
                                    System.out.println("Calificacion de "+doc.getString("nombre")+" "+doc.getString("apellidos")+": ");

                                    Bson filtro2 = Filters.eq("_id", doc.getString("_id"));
                                    Bson update = Updates.push("notas", Double.parseDouble(t.nextLine()));
                                    colAlumnos.updateOne(filtro2, update);
                                }
                            }
                            case 2 -> {
                            /*
                                Se pide por teclado el id de un curso y, si existe, se piden los datos de un tema por
                                teclado y se añade un documento con los datos del tema al array temas.
                            */
                                System.out.println("Introduce el id del curso: ");
                                String idCurso = t.nextLine();

                                Bson filtro = Filters.eq("_id", idCurso);
                                Document doc = colCursos.find(filtro).first();

                                if(doc != null) {
                                    System.out.println("Introduce el nombre del tema: ");
                                    String nombre = t.nextLine();
                                    System.out.println("Introduce las horas del tema: ");
                                    int horas = Integer.parseInt(t.nextLine());

                                    Document tema = new Document();
                                    tema.append("nombre", nombre);
                                    tema.append("horas", horas);

                                    Bson update = Updates.push("temas", tema);
                                    colCursos.updateOne(filtro, update);
                                }else{
                                    System.out.println("Curso no encontrado.");
                                }
                            }
                            case 3 -> {
                            /*
                                Se pide por teclado el id de un curso y, si existe, se escribe el título del curso y las horas
                                de duración. A continuación, se escribe un listado ordenado por apellidos, nombre de
                                los alumnos del curso con valor en nota_media mayor o igual que 5 (apellidos, nombre,
                                nota_media).
                            */
                                System.out.println("Introduce el id del curso: ");
                                String idCurso = t.nextLine();

                                Bson filtro = Filters.eq("_id", idCurso);
                                Document doc = colCursos.find(filtro).first();

                                if(doc != null) {
                                    System.out.println("Curso: "+doc.getString("titulo")+"\tHoras: "+doc.getInteger("horas"));

                                    Bson filtro2 = Filters.and(Filters.eq("curso", idCurso), Filters.gte("nota_media", 5));
                                    MongoCursor<Document> cursor = colAlumnos.find(filtro2).sort(ascending("apellidos", "nombre")).iterator();

                                    while(cursor.hasNext()){
                                        Document doc2 = cursor.next();
                                        System.out.println(doc2.getString("apellidos")+", "+doc2.getString("nombre")+", "+doc2.getDouble("nota_media"));
                                    }
                                }else{
                                    System.out.println("Curso no encontrado.");
                                }
                            }
                            case 4 -> {
                            /*
                                Se escriben en pantalla los títulos de los cursos, cuantos alumnos hay en cada uno de
                                esos cursos y la media de las notas medias de los alumnos de cada curso.

                                Debes realizarlo usando el método aggregate con el que podrías obtener cuantos
                                alumnos hay para cada código de curso. Por cada resultado habría que obtener el título
                                del curso. De esta forma no saldrían los cursos en los que no hay alumnos matriculados.
                                Esto es un ejemplo de cómo se obtendría para cada curso el número de alumnos
                                matriculados.

                                cursor = alumnos.aggregate(Arrays.asList(Aggregates.group("$curso", Accumulators.sum("num", 1)))).iterator();

                                Otro modo de realizarlo sería consultando primero los cursos existentes y, para cada
                                curso, obteniendo cuantos alumnos hay. Aplicando el método count a consultar los
                                alumnos de un curso.
                            */
                                List<Document> cursos = colCursos.find().into(new ArrayList<>());

                                for(Document curso : cursos){
                                    Bson filtro = Filters.eq("curso", curso.getString("_id"));
                                    long numAlumnos = colAlumnos.countDocuments(filtro);
                                    double media = colAlumnos.aggregate(List.of(
                                            match(filtro),// match hace un filtro de los documentos que cumplan la condición dada
                                            group("$curso", Accumulators.avg("media", "$nota_media"))// group agrupa los documentos por el campo dado y Accumulators.avg calcula la media de los valores del campo dado
                                            // $curso hace referencia al campo curso del documento actual y $nota_media hace referencia al campo nota_media del documento actual
                                    )).first().getDouble("media");// first obtiene el primer documento del cursor y getDouble obtiene el valor del campo dado

                                    System.out.println("Curso: "+curso.getString("titulo")+"\tAlumnos: "+numAlumnos+"\tMedia: "+media);
                                }


                            }
                            case 5 -> {
                            /*
                                Se pide por teclado el id de un alumno y, si existe, se calcula la nota media del array de
                                notas y se modifica con esa nota calculada el valor del atributo nota_media.
                                Debes extraer el contenido del atributo notas en un ArrayLis
                            */
                                System.out.println("Introduce el id del alumno: ");
                                String idAlumno = t.nextLine();

                                Bson filtro = Filters.eq("_id", idAlumno);
                                Document doc = colAlumnos.find(filtro).first();

                                if(doc != null) {
                                    List<Double> notas = doc.getList("notas", Double.class);
                                    double media = 0;
                                    for (Double nota : notas) {
                                        media += nota;
                                    }
                                    media /= notas.size();

                                    Bson update = Updates.set("nota_media", media);
                                    colAlumnos.updateOne(filtro, update);
                                }else{
                                    System.out.println("Alumno no encontrado.");
                                }

                            }
                            case 6 -> {
                            /*
                                Se pide por teclado el id de un curso y, si existe, se calculan las horas del curso como
                                suma de las horas de los temas. Si no hay temas cargados, las horas serán cero. Con el
                                valor calculado de horas, se modificará el valor del atributo horas del curso.
                             */
                                System.out.println("Introduce el id del curso: ");
                                String idCurso = t.nextLine();

                                Bson filtro = Filters.eq("_id", idCurso);
                                Document doc = colCursos.find(filtro).first();

                                if(doc != null) {
                                    List<Document> temas = doc.getList("temas", Document.class);
                                    int horas = 0;
                                    for (Document tema : temas) {
                                        horas += tema.getInteger("horas");
                                    }

                                    Bson update = Updates.set("horas", horas);
                                    colCursos.updateOne(filtro, update);
                                }else{
                                    System.out.println("Curso no encontrado.");
                                }

                            }
                            case 7 -> {
                            /*
                                Se pide por teclado el id de un alumno y, si existe, se escribe en pantalla el nombre y
                                apellidos del alumno, la nota media y las notas de cada uno de los temas.Se pide por teclado el id de un alumno y, si existe, se escribe su nombre y apellidos y el
                                título del curso en el que está matriculado.
                             */
                                System.out.println("Introduce el id del alumno: ");
                                String idAlumno = t.nextLine();

                                Bson filtro = Filters.eq("_id", idAlumno);
                                Document doc = colAlumnos.find(filtro).first();

                                if(doc != null) {
                                    System.out.println("Alumno: "+doc.getString("nombre")+" "+doc.getString("apellidos"));
                                    System.out.println("Nota media: "+doc.getDouble("nota_media"));
                                    List<Double> notas = doc.getList("notas", Double.class);
                                    for (int i = 0; i < notas.size(); i++) {
                                        System.out.println("Nota "+(i+1)+": "+notas.get(i));
                                    }

                                    Document curso = colCursos.find(Filters.eq("_id", doc.getString("curso"))).first();
                                    System.out.println("Curso: "+curso.getString("titulo"));
                                }else{
                                    System.out.println("Alumno no encontrado.");
                                }

                            }
                            case 8 -> {
                            /*
                                Se pide por teclado el id de un curso y, si existe, se obtiene y escribe la nota media en el
                                curso, es decir, la nota media de las notas medias de los alumnos del curso.
                             */
                                System.out.println("Introduce el id del curso: ");
                                String idCurso = t.nextLine();

                                Bson filtro = Filters.eq("_id", idCurso);
                                Document doc = colCursos.find(filtro).first();

                                if(doc != null) {
                                    double media = colAlumnos.aggregate(List.of(
                                            match(Filters.eq("curso", idCurso)),
                                            group("$curso", Accumulators.avg("media", "$nota_media"))
                                    )).first().getDouble("media");

                                    System.out.println("Nota media: " + media);
                                }

                            }
                            case 9 -> {
                            /*
                                A todos los alumnos del curso que se indique por teclado se les sube la nota media 0.1
                                puntos.
                             */
                                System.out.println("Introduce el id del curso: ");
                                String idCurso = t.nextLine();

                                Bson filtro = Filters.eq("curso", idCurso);
                                MongoCursor<Document> cursor = colAlumnos.find(filtro).iterator();

                                while(cursor.hasNext()){
                                    Document doc = cursor.next();
                                    double media = doc.getDouble("nota_media") + 0.1;

                                    Bson filtro2 = Filters.eq("_id", doc.getString("_id"));
                                    Bson update = Updates.set("nota_media", media);
                                    colAlumnos.updateOne(filtro2, update);
                                }
                            }
                            case 0 -> {
                                System.out.println("Saliendo...");
                            }
                            default -> System.out.println("Opción no válida.");
                        }

                    } while (op != 0);
                }else{
                    System.out.println("Colección " + nomCol2 + " no encontrada.");
                }
            } else {
                System.out.println("Colección " + nomCol1 + " no encontrada.");
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
