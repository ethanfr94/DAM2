package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner t = new Scanner(System.in);

        try{

            JAXBContext jax = JAXBContext.newInstance(Universidad.class);
            Unmarshaller um = jax.createUnmarshaller();

            Universidad uni = (Universidad) um.unmarshal(new File("universidad.xml"));

            System.out.println("Introduce codigo de departamento: ");
            String cod = t.nextLine();

            boolean encontrado = false;

            for(Departamento dep : uni.getDepartamentos()){
                if(dep.getCodigo().equalsIgnoreCase(cod)){
                    System.out.println("Codigo: " + dep.getCodigo());
                    System.out.println("Nombre: " + dep.getNombre());
                    System.out.println("Telefono: " + dep.getTelefono());
                    System.out.println("Tipo: " + dep.getTipo());
                    System.out.println("Empleados: ");
                    for(Empleado emp : dep.getEmpleados()){
                        System.out.println("Nombre: " + emp.getNombre());
                        System.out.println("Puesto: " + emp.getPuesto());
                        System.out.println("Salario: " + emp.getSalario());
                    }
                    encontrado = true;
                }
            }
            if(!encontrado){
                System.out.println("Departamento no encontrado");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }



    }
}