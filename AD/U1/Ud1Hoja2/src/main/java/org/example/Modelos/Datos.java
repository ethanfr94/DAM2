package org.example.Modelos;

public class Datos {
    private Acts act;
    private Mov mov;
    private Charac charac;

    public Datos(Acts act, Mov mov, Charac charac) {
        this.act = act;
        this.mov = mov;
        this.charac = charac;
    }

    public Acts getAct() {
        return act;
    }

    public Mov getMov() {
        return mov;
    }

    public Charac getCharac() {
        return charac;
    }
}
