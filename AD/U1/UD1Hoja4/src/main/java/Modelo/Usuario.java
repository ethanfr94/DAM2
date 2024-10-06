package Modelo;



import java.time.LocalDate;

public class Usuario {
    private String user;
    private String password;
    private String nombre;
    private String apellidos;
    private LocalDate fnac;
    private int numVotos;

    public Usuario() {
    }

    public Usuario(String user, String password, String nombre, String apellidos, LocalDate fnac, int numVotos) {
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fnac = fnac;
        this.numVotos = numVotos;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFnac() {
        return fnac;
    }

    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fnac=" + fnac +
                ", numVotos=" + numVotos +
                '}';
    }
}
