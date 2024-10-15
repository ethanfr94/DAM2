package Modelo;

import java.sql.Date;
import java.sql.Time;

public class Emitido {
    private int num_emision;
    private Video video;
    private Date fecha;
    private Time hora;
    private int num_solicitudes;

    public Emitido() {
    }

    public int getNum_emision() {
        return num_emision;
    }

    public void setNum_emision(int num_emision) {
        this.num_emision = num_emision;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getNum_solicitudes() {
        return num_solicitudes;
    }

    public void setNum_solicitudes(int num_solicitudes) {
        this.num_solicitudes = num_solicitudes;
    }

    @Override
    public String toString() {
        return "Emitido{" +
                "num_emision=" + num_emision +
                ", video=" + video +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", num_solicitudes=" + num_solicitudes +
                '}';
    }
}
