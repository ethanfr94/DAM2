import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private int edad;
    private String DNI;
    private int registro;

    public Persona(String nombre, int edad, String DNI) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDNI() {
        return DNI;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return nombre+" "+edad+" "+DNI+" "+registro;
    }
}
