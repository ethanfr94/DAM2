package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

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
                            
                            1.- Añadir Comunidad Autónoma sin provincias
                            2.- Consultar Comunidad Autónoma
                            3.- Asignar provincias a Comunidad Autónoma
                            4.- Añadir provincia a Comunidad Autónoma
                            5.- Modificar nombre de Comunidad Autónoma
                            6.- Eliminar provincia en Comunidad Autónoma
                            7.- Asignar capital a Comunidad Autónoma
                            8.- Asignar fecha Estatuto Autonomía
                            9.- Eliminar Comunidad Autónoma
                            0.- Salir
                            """);

                    op = Integer.parseInt(t.nextLine());

                    switch (op) {
                        case 1 -> {
                            System.out.println("introduce codigo de comunidad autónoma");
                            String cod = t.nextLine();
                            System.out.println("introduce nombre de comunidad autónoma");
                            String nom = t.nextLine();
                            System.out.println("introduce abreviatura de comunidad autónoma");
                            String Abr = t.nextLine();
                            System.out.println("introduce habitantes de comunidad autónoma");
                            int pob = Integer.parseInt(t.nextLine());
                            System.out.println("introduce superficie de comunidad autónoma");
                            int sup = Integer.parseInt(t.nextLine());
                            System.out.println("ntroduce capital de comunidad autónoma");
                            String cap = t.nextLine();
                            System.out.println("introduce habitantes de la capital de comunidad autónoma");
                            int pobCap = Integer.parseInt(t.nextLine());
                            List<String> provincias = new ArrayList<>();

                            Document docCap = new Document();
                            docCap.append("nombre", cap);
                            docCap.append("habitantes", pobCap);

                            Document doc = new Document();
                            doc.append("codigo", cod);
                            doc.append("nombre", nom);
                            doc.append("abreviatura", Abr);
                            doc.append("capital", docCap);
                            doc.append("provincias", provincias);
                            doc.append("extension", sup);
                            doc.append("habitantes", pob);

                            try {
                                collection.insertOne(doc);
                                System.out.println("Comunidad Autónoma añadida correctamente.");
                            } catch (Exception e) {
                                System.out.println("Error al añadir Comunidad Autónoma.");
                            }
                        }
                        case 2 -> {
                            System.out.println("introduce codigo de comunidad autónoma");
                            String cod = t.nextLine();

                            Bson filter = eq("codigo", cod);
                            Document doc = collection.find(filter).first();

                            /*
                            Document doc = collection.find(eq("codigo", cod))
                                                            .projection(new Document("nombre", 1)
                                                            .append("habitantes", 1)
                                                            .append("extension", 1)
                                                            .append("capital", 1))
                                                            .append("_id", 0)
                                                            .first();
                            */

                            if (doc == null) {
                                System.out.println("Comunidad Autónoma no encontrada.");
                            } else {
                                Integer habitantes = doc.getInteger("habitantes");

                                System.out.println("Nombre: " + doc.getString("nombre"));
                                if (habitantes != null) {
                                    System.out.println("Habitantes: " + habitantes);
                                } else {
                                    System.out.println("Habitantes: Sin datos");
                                }
                                System.out.println("Extensión: " + doc.getInteger("extension"));
                                Document docCap = doc.get("capital", Document.class);
                                if (docCap != null) System.out.println("Capital: " + docCap.getString("nombre"));

                                System.out.println(doc.toJson());
                            }
                        }
                        case 3 -> {
                            System.out.println("introduce codigo de comunidad autónoma");
                            String cod = t.nextLine();

                            Bson filter = eq("codigo", cod);
                            Document doc = collection.find(filter).first();

                            if (doc == null) {
                                System.out.println("Comunidad Autónoma no encontrada.");
                            } else {
                                String nomProv;
                                List<String> provincias = new ArrayList<>();
                                do {
                                    System.out.println("introduce nombre de provincia (Intro para finalizar)");
                                    nomProv = t.nextLine();
                                    if (!nomProv.equals("")) {
                                        provincias.add(nomProv);
                                        collection.updateOne(eq("codigo", cod), set("provincias", nomProv));
                                    }
                                } while (!nomProv.equals(""));

                                Bson update = Updates.set("provincias", provincias);

                                UpdateResult ok = collection.updateOne(filter, update);
                                if (ok.getModifiedCount() > 0) {
                                    System.out.println("Provincias añadidas correctamente.");
                                } else {
                                    System.out.println("Error al añadir provincias.");
                                }
                            }
                        }
                        case 4 -> {
                            System.out.println("introduce codigo de comunidad autónoma");
                            String cod = t.nextLine();

                            Bson filter = eq("codigo", cod);
                            Document doc = collection.find(filter).first();

                            if (doc == null) {
                                System.out.println("Comunidad Autónoma no encontrada.");
                            } else {
                                System.out.println("introduce nombre de provincia");
                                String nomProv = t.nextLine();

                                if (!nomProv.equals("")) {
                                    try {
                                        UpdateResult ok = collection.updateOne(eq("codigo", cod), addToSet("provincias", nomProv));
                                        if (ok.getModifiedCount() > 0) {
                                            System.out.println("Provincia añadida correctamente.");
                                        } else {
                                            System.out.println("Error al añadir provincia.");
                                        }
                                    } catch (Exception e) {
                                        e.getMessage();
                                    }
                                }
                            }
                        }
                        case 5 -> {
                            System.out.println("introduce codigo de comunidad autónoma");
                            String cod = t.nextLine();

                            Bson filter = eq("codigo", cod);
                            Document doc = collection.find(filter).first();

                            if (doc == null) {
                                System.out.println("Comunidad Autónoma no encontrada.");
                            } else {
                                System.out.println("introduce nombre");
                                String nom = t.nextLine();

                                try {
                                    UpdateResult ok = collection.updateOne(eq("codigo", cod), set("nombre", nom));
                                    if (ok.getModifiedCount() > 0) {
                                        System.out.println("Nombre modificado correctamente.");
                                    } else {
                                        System.out.println("Error al modificar nombre.");
                                    }
                                } catch (Exception e) {
                                    e.getMessage();
                                }
                            }
                        }
                        case 6 -> {
                            System.out.println("introduce codigo de comunidad autónoma");
                            String cod = t.nextLine();

                            Bson filter = eq("codigo", cod);
                            Document doc = collection.find(filter).first();

                            if (doc == null) {
                                System.out.println("Comunidad Autónoma no encontrada.");
                            } else {
                                
                            }

                        }
                        case 7 -> {
                            System.out.println("introduce codigo de comunidad autónoma");
                            String cod = t.nextLine();

                            Bson filter = eq("codigo", cod);
                            Document doc = collection.find(filter).first();

                            if (doc == null) {
                                System.out.println("Comunidad Autónoma no encontrada.");
                            } else {
                                if(doc.get("capital", Document.class) == null) {
                                    System.out.println("introduce capital de comunidad autónoma");
                                    String cap = t.nextLine();
                                    System.out.println("introduce habitantes de la capital de comunidad autónoma");
                                    int pobCap = Integer.parseInt(t.nextLine());

                                    Document docCap = new Document();
                                    docCap.append("nombre", cap);
                                    docCap.append("habitantes", pobCap);

                                    try {
                                        UpdateResult ok = collection.updateOne(eq("codigo", cod), set("capital", docCap));
                                        if (ok.getModifiedCount() > 0) {
                                            System.out.println("Capital añadida correctamente.");
                                        } else {
                                            System.out.println("Error al añadir capital.");
                                        }
                                    } catch (Exception e) {
                                        e.getMessage();
                                    }
                                } else {
                                    System.out.println("Capital ya asignada.");
                                }
                            }
                        }
                        case 8 -> {
                            System.out.println("introduce codigo de comunidad autónoma");
                            String cod = t.nextLine();

                            Bson filter = eq("codigo", cod);
                            Document doc = collection.find(filter).first();

                            if (doc == null) {
                                System.out.println("Comunidad Autónoma no encontrada.");
                            } else {
                                System.out.println("introduce fecha de Estatuto de Autonomía");
                                System.out.print("Dia:");
                                int dia = Integer.parseInt(t.nextLine());
                                System.out.print("\nMes:");
                                int mes = Integer.parseInt(t.nextLine());
                                System.out.print("\nAño:");
                                int anyo = Integer.parseInt(t.nextLine());

                                String fecha = dia + "/" + mes + "/" + anyo;

                                try {
                                    UpdateResult ok = collection.updateOne(eq("codigo", cod), set("fecha-estatuto", fecha));
                                    if (ok.getModifiedCount() > 0) {
                                        System.out.println("Fecha añadida correctamente.");
                                    } else {
                                        System.out.println("Error al añadir fecha.");
                                    }
                                } catch (Exception e) {
                                    e.getMessage();
                                }
                            }
                        }
                        case 9 -> {
                            System.out.println("introduce codigo de comunidad autónoma");
                            String cod = t.nextLine();

                            Bson filter = eq("codigo", cod);
                            Document doc = collection.find(filter).first();

                            if (doc == null) {
                                System.out.println("Comunidad Autónoma no encontrada.");
                            } else {
                                System.out.println(doc.toJson());

                                System.out.println("¿Eliminar la Comunidad Autónoma? (S/N)");
                                String resp = t.nextLine();

                                if (resp.equalsIgnoreCase("S")) {
                                    try {
                                        collection.deleteOne(eq("codigo", cod));
                                        System.out.println("Comunidad Autónoma eliminada correctamente.");
                                    } catch (Exception e) {
                                        System.out.println("Error al eliminar Comunidad Autónoma.");
                                    }
                                }
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