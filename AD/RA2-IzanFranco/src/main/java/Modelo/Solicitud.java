package Modelo;

import java.sql.Date;
import java.sql.Time;

public class Solicitud {
    private int num;
    private Usuario user;
    private Video video;
    private Date fecha;
    private Time hora;
    private String via;

    public Solicitud() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
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

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "num=" + num +
                ", user=" + user +
                ", video=" + video +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", via='" + via + '\'' +
                '}';
    }
}
