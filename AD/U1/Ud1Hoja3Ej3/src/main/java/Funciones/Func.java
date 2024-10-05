package Funciones;

import Modelo.Usuario;

import java.util.Scanner;

public class Func {
    public static Usuario introUser(){
        Scanner t = new Scanner(System.in);
        Usuario u = new Usuario();
        System.out.println("Introduce el nombre de usuario: ");
        u.setUser(t.nextLine());
        System.out.println("Introduce la contraseña: ");
        u.setPassword(t.nextLine());
        return u;
    }
}
