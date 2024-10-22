package org.example;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args)  {
        File fich=new File("script.sql");
        String script=null;
        try {
            BufferedReader f=new BufferedReader(new FileReader(fich));
            //Procesar el fichero para crear una cadena con el script
            String linea=f.readLine();
            StringBuilder stringBuilder=new StringBuilder();
            while(linea!=null){
                stringBuilder.append(linea);
                linea=f.readLine();
            }
            f.close();
            script=stringBuilder.toString();
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR, no existe el fichero");
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //Ya tenemos la cadena con el script, si todo ha ido bien

        if(script!=null){
            //En la URL de conexión se pide, en un parámetro, la ejecución de scripts
            Connection con=Conexion.getConexion();
            try {
                //Establecemos el estado transaccional
                // Para que quede ejecutado todo el script o bien
                // se anule todo lo que se hubiera ejecutado si hay algún fallo
                con.setAutoCommit(false);

                //Ejecutar el script
                Statement st=con.createStatement();
                st.executeUpdate(script);

                //confirmar la transancción
                con.commit();
                System.out.println("Se ha realizado terminado la ejecución del script");
                st.close();
                con.close();
            } catch (SQLException ex) {
                try {
                    // Algo ha fallado en la ejecución del script, se anula la transacción
                    con.rollback();
                    System.out.println("ERROR "+ex.getErrorCode()+":"+ex.getMessage());

                } catch (SQLException ex2) {
                    System.out.println("ERROR "+ex.getErrorCode()+":"+ex.getMessage());
                }
            }
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println("Error al leer el script");
        }

    }
}