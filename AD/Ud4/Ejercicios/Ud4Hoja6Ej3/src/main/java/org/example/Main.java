package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JAXBException {

        /*
        A partir del fichero futbolistas.xml que tienes en la carpeta RECURSOS de la Unidad 4
        del curso Moodle, desarrolla un programa java que usa JAXB y que permite realizar las
        siguientes operaciones sobre ese fichero:
        1.- Listar futbolistas
        2.- Consultar futbolista por número
        3.- Modificar equipo de futbolista
        4.- Eliminar futbolista

         */

        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Futbolistas.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Futbolistas futbolistas = (Futbolistas) unmarshaller.unmarshal(new File("futbolistas.xml"));

            Scanner t = new Scanner(System.in);
            int op = -1;

            do{
                System.out.println("""
                    
                    1.- Listar futbolistas
                    2.- Consultar futbolista por número
                    3.- Modificar equipo de futbolista
                    4.- Eliminar futbolista
                    0.- Salir
                    
                    """);

                op = Integer.parseInt(t.nextLine());

                switch (op){
                    case 1->{
                        //Opción 1: Realiza un listado encolumnado con los datos de todos los futbolistas.

                        System.out.println("Listado de futbolistas");
                        System.out.println("Num   Alias                Posicion             Altura     Equipo");
                        System.out.println("-----------------------------------------------------------------");
                        futbolistas.getFutbolistas().forEach(futbolista -> {
                            System.out.printf("%-5d %-20s %-20s %-10.2f %-5s\n", futbolista.getNum(), futbolista.getAlias(), futbolista.getPosicion(), futbolista.getAltura(), futbolista.getEquipo());
                        });
                    }
                    case 2->{
                        // Opción 2: Pide que se introduzca por teclado un número de futbolista y escribe en
                        // pantalla sus datos o, en su caso, un mensaje de que no existe.

                        System.out.println("Introduce número de futbolista: ");
                        int num = Integer.parseInt(t.nextLine());
                        Futbolista futbolista = futbolistas.getFutbolistaByNum(num);

                        if(futbolista != null){
                            System.out.println("Num   Alias                Posicion             Altura     Equipo");
                            System.out.println("-----------------------------------------------------------------");
                            System.out.printf("%-5d %-20s %-20s %-10.2f %-5s\n", futbolista.getNum(), futbolista.getAlias(), futbolista.getPosicion(), futbolista.getAltura(), futbolista.getEquipo());
                        }
                        else System.out.println("Futbolista no encontrado");


                    }
                    case 3->{
                        // Opción 3: Pide que se introduzca por teclado un número de futbolista y, si existe, escribe
                        // sus datos en pantalla, pide por teclado un nuevo código de equipo para el futbolista y se
                        // modifica ese código en el fichero.

                        System.out.println("Introduce número de futbolista: ");
                        int num = Integer.parseInt(t.nextLine());
                        Futbolista futbolista = futbolistas.getFutbolistaByNum(num);

                        if(futbolista != null){
                            System.out.println("Futbolista encontrado");
                            System.out.println("Num   Alias                Posicion             Altura     Equipo");
                            System.out.println("-----------------------------------------------------------------");
                            System.out.printf("%-5d %-20s %-20s %-10.2f %-5s\n", futbolista.getNum(), futbolista.getAlias(), futbolista.getPosicion(), futbolista.getAltura(), futbolista.getEquipo());

                            System.out.println("Introduce nuevo equipo: ");
                            String equipo = t.nextLine();
                            futbolista.setEquipo(equipo);

                            marshaller.marshal(futbolistas, new File("futbolistas.xml"));
                            System.out.println("Equipo modificado");
                        }
                        else System.out.println("Futbolista no encontrado");

                    }
                    case 4->{
                        // Opción 4: Pide que se introduzca por teclado un número de futbolista y, si existe, escribe
                        // sus datos en pantalla y lo elimina del fichero.

                        System.out.println("Introduce número de futbolista: ");
                        int num = Integer.parseInt(t.nextLine());
                        Futbolista futbolista = futbolistas.getFutbolistaByNum(num);

                        if(futbolista != null){
                            System.out.println("Futbolista encontrado");
                            System.out.println("Num   Alias                Posicion             Altura     Equipo");
                            System.out.println("-----------------------------------------------------------------");
                            System.out.printf("%-5d %-20s %-20s %-10.2f %-5s\n", futbolista.getNum(), futbolista.getAlias(), futbolista.getPosicion(), futbolista.getAltura(), futbolista.getEquipo());

                            futbolistas.removeFutbolista(futbolista);
                            marshaller.marshal(futbolistas, new File("futbolistas.xml"));
                            System.out.println("Futbolista eliminado");
                        }
                        else System.out.println("Futbolista no encontrado");

                    }
                    case 0->{
                        System.out.println("Saliendo...");
                    }
                    default -> System.out.println("Opción no válida");
                }

            }while (op != 0);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}