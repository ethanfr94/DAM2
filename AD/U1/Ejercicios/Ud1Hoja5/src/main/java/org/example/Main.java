package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /*EJERCICIO 1 Realiza un programa que lee el fichero script datos_coches.sql y:
     • Utilizando la propiedad permitir ejecución de scripts en la conexión,
     realiza un programa que conecta con un servidor mysql y crea la base de datos coches ejecutando ese script.

     EJERCICIO 2 Previamente, debes establecer con DBeaver una conexión con PosgreSQL Server y crear una base de datos héroes.
     Realiza un programa que conecta a la base de datos héroes de PostgreSQL, lee el fichero script heroes_postgres.sql
     y: • Añade tablas y datos de éstas a la base de datos héroes a partir de las instrucciones del script.

     EJERCICIO 3 Importa mediante Workbench en tu servidor MySQL la base de datos ligatercera cuyo script de
     importación es ligatercera.sql. En la base de datos, aparte de las tablas de la base de datos,
     hay un procedimiento siguientejornada que recibe como parámetro un número de jornada (entre 1 y 18)
     y genera los partidos correspondientes a la siguiente jornada. Por ejemplo, si se pasa el número de jornada 2,
     genera los partidos de la jornada 3. Realiza un programa que obtiene el número de jornada mayor que hay en la tabla partidos y:
     -Genera los partidos de la siguiente jornada. -Muestra en pantalla los partidos que se juegan la siguiente jornada (los generados). */

    public static void main(String[] args){
        //ejecutarScript(Conn.getConexion(), "..\\datos_coches.sql");
        exescript();


    }

    private static void ejecutarScript(Connection connection, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             Statement statement = connection.createStatement()) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line);
                if (line.trim().endsWith(";")) {
                    statement.execute(sql.toString());
                    sql.setLength(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exescript(){
        String ruta = "..\\datos_coches.sql";
        String script;
        Connection con = Conn.getConexion();
        try(BufferedReader br= new BufferedReader(new FileReader(ruta)); Statement st = con.createStatement();){

            StringBuilder sb = new StringBuilder();
            while((script = br.readLine()) != null){
                sb.append(script);
                if (script.trim().endsWith(";")) {
                    st.execute(sb.toString());
                    sb.setLength(0);
                }
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}