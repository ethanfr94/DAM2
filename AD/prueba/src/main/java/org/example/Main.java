package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //if(ConexionSQLite.getConexion()!=null){
        if (ConexionMySQLSingleton.getConexion() != null) {

            System.out.println("conexion ok");
            //String sql="select id, nombre, poderes from superheroes";
            String sql = "select city.name, countrycode, city.population, country.name as pais from city inner join country on code=countrycode";
            //String sql1="create table if not exists superheroes(id integer primary key autoincrement, nombre text not null, poderes text)";
            //String sql2="insert into superheroes (nombre, poderes) values ('superman','volar, fuerza'),('superwoman','volar, charlar')";
            try {
                //Statement st=ConexionSQLite.getConexion().createStatement();
                Statement st = ConexionMySQLSingleton.getConexion().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int poblacion = rs.getInt("population");
                    String nombre = rs.getString("name");
                    String cod = rs.getString("pais");
                    System.out.println(poblacion + " - " + nombre + " - " + cod);
                }
                //st.executeUpdate(sql1);
                //int n= st.executeUpdate(sql2);
                //System.out.println("se añadieron "+n+" superheroes");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            ConexionMySQLSingleton.cerrar();

        } else {
            System.out.println("conexion fallida");
        }
        if (ConexionSQLite.getConexion() != null) {
            ConexionSQLite.cerrar();
        }
    }
}