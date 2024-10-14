package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));// creamos un buffer para leer el archivo
             Statement statement = connection.createStatement()) {// creamos un statement para ejecutar las sentencias
            StringBuilder sql = new StringBuilder();// creamos un stringbuilder para concatenar las sentencias
            String line;
            while ((line = br.readLine()) != null) {// leemos el archivo línea a línea
                sql.append(line);// añadimos la línea al stringbuilder
                if (line.trim().endsWith(";")) {// si la línea termina en ; es que es una sentencia sql
                    statement.execute(sql.toString());// ejecutamos la sentencia
                    sql.setLength(0);// vaciamos el stringbuilder
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exescript(){
        String ruta = "..\\datos_coches.sql";
        String script;//variable para guardar las lineas del script
        Connection con = Conn.getConexion();//creamos la conexion
        try(BufferedReader br= new BufferedReader(new FileReader(ruta)); Statement st = con.createStatement();){//creamos el buffer para leer el archivo

            StringBuilder sb = new StringBuilder();// creamos un stringbuilder para concatenar las sentencias
            while((script = br.readLine()) != null){// leemos el archivo línea a línea
                sb.append(script);// añadimos la línea al stringbuilder
                if (script.trim().endsWith(";")) {// si la línea termina en ; es que es una sentencia sql
                    st.execute(sb.toString());// ejecutamos la sentencia
                    sb.setLength(0);// vaciamos el stringbuilder
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