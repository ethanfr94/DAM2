package Modelo;

import java.sql.Date;

public class Votos {
    private Usuario usuario;
    private Cancion cancion;
    private Date fecha;

    public Votos() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Votos{" +
                "usuario=" + usuario +
                ", cancion=" + cancion +
                ", fecha=" + fecha +
                '}';
    }
}
