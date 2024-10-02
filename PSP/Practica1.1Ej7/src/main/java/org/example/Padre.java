package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Padre {
    public static String aleatorios() {
        String msg = "";
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        String com = "java -jar D:\\Usuarios\\dam2\\Desktop\\DAM\\PSP\\Practica1.1Ej7";
        try {
            do {
                System.out.println("Escribe una linea, fin para finalizar el programa");
                msg = new Scanner(System.in).nextLine();
                if (msg.equals("fin")) {
                    System.exit(0);
                } else {
                    process = runtime.exec(com);
                    OutputStream os = process.getOutputStream();
                    os.write(msg.getBytes());
                    os.flush();

                    InputStream is = process.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    br.close();
                }
            } while (true);
        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
            System.exit(-1);
        }
        return msg;
    }
}
