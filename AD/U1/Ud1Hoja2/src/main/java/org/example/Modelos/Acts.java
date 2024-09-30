package org.example.Modelos;

public class Acts {
    private int id;
    private Charac charac;
    private Mov mov;
    private Integer minutes;
    private boolean main;
    private String actor;

    public Acts() {
    }

    public Acts(Mov m, Charac charac, Integer minutes, boolean main, String actor) {
        this.mov = m;
        this.charac = charac;
        this.minutes = minutes;
        this.main = main;
        this.actor = actor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Charac getCharac() {
        return charac;
    }

    public void setCharac(Charac charac) {
        this.charac = charac;
    }

    public Mov getMov() {
        return mov;
    }

    public void setMov(Mov mov) {
        this.mov = mov;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Acts" +
                "charac=" + charac.toString() +
                "\nmov=" + mov.toString() +
                "\nminutes=" + minutes +
                "\nmain=" + main +
                "\nactor='" + actor;
    }
}
