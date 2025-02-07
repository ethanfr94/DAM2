package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JAXBException {
        /*
        Realiza un programa que añade atletas a un fichero XML que contiene información de
        atletas que participarán en una maratón. Cada vez que se ejecuta el programa se pueden
        añadir varios atletas.
        */

        Scanner t = new Scanner(System.in);
        int n = -1;
        int dorsal = 0;

        Maraton maraton = new Maraton();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Maraton.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            do {
                System.out.println("Añadir atleta? (1. Si, 0. No)");
                n = Integer.parseInt(t.nextLine()
                );
                if (n == 0) {
                    break;
                }
                System.out.println("Nombre: ");
                String nombre = t.nextLine();
                System.out.println("Apellidos: ");
                String apellidos = t.nextLine();
                System.out.println("Fecha de nacimiento: ");
                String fechaNacimiento = t.nextLine();

                maraton.addAtleta(new Atleta(dorsal++, nombre, apellidos, fechaNacimiento, "ESP", Math.round(Math.random() * 1000.0) / 100.0));

                marshaller.marshal(maraton, new File("atletas.xml"));

            } while (n != 0);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}