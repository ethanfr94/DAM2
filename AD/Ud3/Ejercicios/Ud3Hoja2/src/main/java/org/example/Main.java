package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.OFF);

        MongoClient client = MongoClients.create("mongodb://10.0.22.74:3406");

        if(client != null) {
            System.out.println("Connected to MongoDB");
        } else {
            System.out.println("Failed to connect to MongoDB");
        }

        MongoDatabase db = client.getDatabase("centrodb");

        MongoCollection<Document> collection = db.getCollection("alumnos");

        MongoCursor<Document> cursor = collection.find().iterator();

        while(cursor.hasNext()) {
            Document doc = cursor.next();
            System.out.println(doc.getString("nombre")+ " --- " + doc.getString("apellidos"));
        }

    }
}