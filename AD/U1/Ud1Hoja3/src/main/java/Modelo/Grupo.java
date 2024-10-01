package Modelo;

import java.sql.Date;

public class Grupo {
    private int codgrupo;
    private String nombre;
    private String localidad;
    private String estilo;
    private boolean esGrupo;
    private int annoGrab;
    private Date fechaEstreno;
    private String compania;

    public Grupo() {
    }

    public int getCodgrupo() {
        return codgrupo;
    }

    public void setCodgrupo(int codgrupo) {
        this.codgrupo = codgrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public boolean isEsGrupo() {
        return esGrupo;
    }

    public void setEsGrupo(boolean esGrupo) {
        this.esGrupo = esGrupo;
    }

    public int getAnnoGrab() {
        return annoGrab;
    }

    public void setAnnoGrab(int anioGrab) {
        this.annoGrab = anioGrab;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Override
    public String toString() {
        return "Grupos{" +
                "codgrupo=" + codgrupo +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", estilo='" + estilo + '\'' +
                ", esGrupo=" + esGrupo +
                ", anioGrab=" + annoGrab +
                ", fechaEstreno=" + fechaEstreno +
                ", compania='" + compania + '\'' +
                '}';
    }
}
