package org.example;

import Conexion.Conn;
import Modelo.Usuario;
import Modelo.Video;
import Servicio.Serv;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner t = new Scanner(System.in);

        System.out.println("introduce usuario: ");
        String usuario = t.nextLine();

        System.out.println("introduce contraseña: ");
        String pass = t.nextLine();

        Connection conn = Conn.getConexion(usuario, pass);

        if (conn == null){
            System.out.println("Error al establecer conexion");
            System.exit(-1);
        }

        int op;
        do {
            System.out.println("""
                    1. Importar datos a SQLite
                    2. Modificar total de peticiones del usuario
                    3. Listar usuarios solicitantes del video
                    4. Eliminar solicitudes del usuario
                    5. Videos con mas solicitudes
                    6. Emitir video
                    0. Salir
                    """);
            switch ( op = Integer.parseInt(t.nextLine())){
                case 1->{
                }
                case 2->{
                    System.out.println("introduce numero de usuario:");
                    int numUsu = Integer.parseInt(t.nextLine());
                    Usuario u = Serv.porId(conn, numUsu);
                    if(u!=null){
                        System.out.printf("%-10s - %-20s\n",u.getNombre(),u.getApellido());
                        if(Serv.modPeticiones(conn, u.getNum_usu())) System.out.println("peticiones modificadas");
                    }else{
                        System.out.println("el usuario no existe");
                    }}
                case 3->{
                    System.out.println("introduce titulo de video:");
                    String titulo = t.nextLine();
                    Video v = Serv.porTitulo(conn, titulo);
                    if(v!=null){
                        List<Usuario> users = Serv.usuariosPorTitulo(conn, v.getTitulo());
                        for (Usuario u:users){
                            System.out.printf("%-10s - %-20s\n",u.getNombre(),u.getApellido());
                        }
                    }}
                case 4->{
                    System.out.println("introduce numero de usuario:");
                    int numUsu = Integer.parseInt(t.nextLine());
                    Serv.videosPorUsuario(conn, numUsu);

                }
                case 5->{
                    System.out.println("introduce numero de solicitudes:");
                    int num = Integer.parseInt(t.nextLine());
                    System.out.println("no ha dado tiempo");

                }
                case 6->{
                    Serv.emitir(conn);
                }
                case 0->{
                    System.out.println("cerrando el programa");
                    System.exit(0);
                }
                default->{
                    System.out.println("opcion no valida");
                }
            }
        }while(op != 0);











        Conn.cerrar();
    }
}