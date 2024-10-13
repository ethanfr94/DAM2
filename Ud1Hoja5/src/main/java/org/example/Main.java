package org.example;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String path = "datos_coches.sql";
        List<String> lineas = new ArrayList<>();

        String script = "";
        try {
            Connection conn = Conexion.Conn.getConexion();
            //script = Files.readString(Paths.get(path));
            lineas = Files.readAllLines(Paths.get(path), java.nio.charset.StandardCharsets.UTF_8);
            for (String linea : lineas) {
                script += linea + "\n";
            }
            conn.setAutoCommit(false); //para que no haga commit automático
            Statement st = conn.createStatement();
            st.execute(script);
            conn.commit();//hace commit
            st.close();
            conn.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
// EJERCICIO 1
// Realiza un programa que lee el fichero script datos_coches.sql y:
// Utilizando la propiedad permitir ejecución de scripts en la conexión,
// realiza un programa que conecta con un servidor mysql y crea la base de datos coches
// ejecutando ese script.
//D:\Usuarios\dam2\Desktop\DAM\AD\U1\Ejercicios\Ud1Hoja5\datos_coches.sql
