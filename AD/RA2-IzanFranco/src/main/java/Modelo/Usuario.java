package Modelo;

import java.sql.Date;

public class Usuario {
    private int num_usu;
    private String usuario;
    private String pass;
    private String nombre;
    private String apellido;
    private Date fechanac;
    private int num_peticiones;

    public Usuario() {
    }

    public int getNum_usu() {
        return num_usu;
    }

    public void setNum_usu(int num_usu) {
        this.num_usu = num_usu;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public int getNum_peticiones() {
        return num_peticiones;
    }

    public void setNum_peticiones(int num_peticiones) {
        this.num_peticiones = num_peticiones;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "num_usu=" + num_usu +
                ", usuario='" + usuario + '\'' +
                ", pass='" + pass + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechanac=" + fechanac +
                ", num_peticiones=" + num_peticiones +
                '}';
    }
}
