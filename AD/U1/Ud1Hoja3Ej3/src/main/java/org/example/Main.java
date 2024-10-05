package org.example;

import Funciones.Func;
import Modelo.Cancion;
import Modelo.Usuario;
import Servicio.Serv;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        Usuario u = Func.introUser();
        if(Serv.validarUser(u)){
            System.out.println("Usuario correcto");
            System.out.println("Introduce el numero de la cancion que quieres votar: ");
            int numCancion = Integer.parseInt(t.nextLine());
            if(Serv.votar(u, numCancion)){
                Serv.actualizarVotos(u, numCancion);
                System.out.println("Voto realizado");
                Cancion c = Serv.porNum(numCancion);
                System.out.println("Cancion votada: " +c.getTitulo()+" de "+c.getGrupo());
                System.out.println("posicion en la lista: "+Serv.posicion(numCancion));
            } else {
                System.out.println("Error al votar");
            }
        } else {
            System.out.println("Usuario incorrecto");
        }

    }
}